package com.pro.manga.controller.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.mail.Multipart;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.Category;
import com.pro.manga.domain.Chapter;
import com.pro.manga.domain.Manga;
import com.pro.manga.domain.PageManga;
import com.pro.manga.domain.MangaCategory;
import com.pro.manga.model.CategoryDto;
import com.pro.manga.model.ChapterDto;
import com.pro.manga.model.MangaDto;
import com.pro.manga.service.CategoryService;
import com.pro.manga.service.ChapterService;
import com.pro.manga.service.MangaCategoryService;
import com.pro.manga.service.MangaService;
import com.pro.manga.service.PageService;
import com.pro.manga.service.StorageService;


@Controller
@RequestMapping("admin/mangas")
public class MangaController implements Serializable{
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	MangaService mangaService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	MangaCategoryService mangaCategoryService;
	
	@Autowired
	PageService pageService;
	
	@Autowired
	ChapterService chapterService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("manga", new MangaDto());
		return "admin/mangas/addOrEdit";
	}
	
	@GetMapping("{mangaId}/addChapter")
	public ModelAndView addChapter(ModelMap model, @PathVariable("mangaId") Long mangaId) {
		
		Optional<Manga> opt=mangaService.findById(mangaId);
		MangaDto dto=new MangaDto();
		if(opt.isPresent()){
			Manga entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("manga", dto);
			
			return new ModelAndView("admin/mangas/addChapter", model);
		}
		
		model.addAttribute("message", "Manga is not existed");
		
		return new ModelAndView("forward:/admin/mangas/addOrEdit", model);
	}
	
	@GetMapping("edit/{mangaId}")
	public ModelAndView edit(ModelMap model, @PathVariable("mangaId") Long mangaId) {
		
		Optional<Manga> opt=mangaService.findById(mangaId);
		MangaDto dto=new MangaDto();
		if(opt.isPresent()){
			Manga entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			
			dto.setIsEdit(true);
			
			model.addAttribute("manga", dto);
			return new ModelAndView("admin/mangas/addOrEdit", model);
		}
		
		model.addAttribute("message", "Manga is not existed");
		
		return new ModelAndView("forward:/admin/mangas/addOrEdit", model);
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\""+file.getFilename()+"\"").body(file);
	}
	
	@GetMapping("delete/{mangaId}")
	public ModelAndView delete(ModelMap model,
			@PathVariable("mangaId") Long mangaId) {
		
		mangaService.deleteById(mangaId);
		model.addAttribute("message", "Manga is deleted");
		return new ModelAndView("forward:/admin/mangas/search", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("manga") MangaDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/mangas/addOrEdit");
		}
		
		Manga entity=new Manga();
		BeanUtils.copyProperties(dto, entity);
		
		if(!dto.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			
			entity.setImage(storageService.getStoredString(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), entity.getImage());
		}
		entity.setLikes(0);
		entity.setNumberOfChapters(0);
		mangaService.save(entity);
		model.addAttribute("message", "Manga is saved");
		return new ModelAndView("forward:/admin/mangas", model);
	}
	
	@PostMapping("addNewChapter")
	public ModelAndView adChapter(ModelMap model, @RequestParam("files") MultipartFile []photos, 
			@RequestParam("chapterNumber") int chapterNumber, @RequestParam("mangaId") Long mangaId) {
		Optional<Manga> opt=mangaService.findById(mangaId);
		Manga manga=new Manga();
		if(opt.isPresent()) {
			manga=opt.get();
			
			Chapter entity =new Chapter();
			entity.setChapterNumber(chapterNumber);
			entity.setManga(manga);
			entity.setNumberOfPages(10);
//			System.out.println(entity);
			int k=1;
			chapterService.save(entity);
			for(MultipartFile i:photos) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				
				PageManga page=new PageManga();
				page.setContent(storageService.getStoredString(i, uuString));
				storageService.store(i, page.getContent());
				page.setNumberPage(k);
				k+=1;
				page.setChapter(entity);
				pageService.save(page);
			}
			return new ModelAndView("forward:/admin/mangas", model);
		}
		
		model.addAttribute("message", "Manga is saved");
		return new ModelAndView("forward:/admin/mangas", model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Manga> list = mangaService.findAll();
//		System.out.println(list);
		
		List<List<MangaCategory>> listAllMCs = new ArrayList<>();
		List<MangaCategory> listMangaCategories = new ArrayList<>();
		for(Manga i:list) {
			System.out.println(i.getName());
		}
		for(Manga i:list) {
			System.out.println(i.getMangaId());
			listMangaCategories = mangaCategoryService.findByMangaId(i.getMangaId());
			for(MangaCategory j : listMangaCategories) {
				System.out.println(j.getMangaCategoryId()+".");
			}
//			System.out.println(listMangaCategories);
//			Optional<MangaCategory> listMangaCategories = mangaCategoryService.findById(i.getMangaId());
//			listAllMCs.add(listMangaCategories);
//			System.out.println(listMangaCategories);
		}
		System.out.println(listMangaCategories);
		System.out.println(listAllMCs);
		
		model.addAttribute("mangas", list);
//		model.addAttribute("listAllMCs", listAllMCs);
		return "admin/mangas/list";
	}
	
	
	@GetMapping("search")
	public String search(ModelMap model,
			@RequestParam(name="name", required = false) String name) {
		List<Category> list=null;
		if(StringUtils.hasText(name)) {
			list=categoryService.findByNameContaining(name);
		}else {
			list=categoryService.findAll();
		}
		
		model.addAttribute("mangas", list);
		
		return "admin/mangas/search";
	}
	
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name="name", required =false) String name, 
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		int currentPage=page.orElse(1);
		int pageSize=size.orElse(5);
		
		Pageable pageable=PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<Category> resultPage=null;
		
		if(StringUtils.hasText(name)) {
			resultPage=categoryService.findByNameContaining(name, pageable);
			model.addAttribute("name", name);
		}else {
			resultPage=categoryService.findAll(pageable);
		}
		
		int totalPages=resultPage.getTotalPages();
		if(totalPages>0) {
			int start=Math.max(1, currentPage-2);
			int end=Math.min(currentPage + 2, totalPages);
			
			if(totalPages>5) {
				if(end==totalPages) {
					start=end-5;
				}else if(start==1) {
					end=start+5;
				}
			}
			List<Integer> pageNumbers=IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		model.addAttribute("categoryPage", resultPage);
		
		
		return "admin/mangas/searchpaginated";
	}
}










