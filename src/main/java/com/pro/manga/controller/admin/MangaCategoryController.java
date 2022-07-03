package com.pro.manga.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.Category;
import com.pro.manga.domain.Manga;
import com.pro.manga.domain.MangaCategory;
import com.pro.manga.model.CategoryDto;
import com.pro.manga.model.MangaCategoryDto;
import com.pro.manga.model.MangaDto;
import com.pro.manga.service.CategoryService;
import com.pro.manga.service.MangaCategoryService;
import com.pro.manga.service.MangaService;


@Controller
@RequestMapping("admin/mangaCategories")
public class MangaCategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	MangaService mangaService;
	
	@Autowired
	MangaCategoryService mangaCategoryService;
	
	
	@ModelAttribute("categories")
	public List<CategoryDto> getCategories(){
		return categoryService.findAll().stream().map(itemCategory->{
			CategoryDto dto=new CategoryDto();
			BeanUtils.copyProperties(itemCategory, dto);
			return dto;
		}).toList();
	}
	
	@ModelAttribute("mangas")
	public List<MangaDto> getMangas(){
		return mangaService.findAll().stream().map(itemManga->{
			MangaDto dto=new MangaDto();
			BeanUtils.copyProperties(itemManga, dto);
			return dto;
		}).toList();
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("mangaCategory", new MangaCategoryDto());
		return "admin/mangaCategories/addOrEdit";
	}
	
	
	
//	@GetMapping("edit/{categoryId}")
//	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
//		
//		Optional<Category> opt=categoryService.findById(categoryId);
//		CategoryDto dto=new CategoryDto();
//		if(opt.isPresent()){
//			Category entity=opt.get();
//			BeanUtils.copyProperties(entity, dto);
//			
//			dto.setIsEdit(true);
//			
//			model.addAttribute("category", dto);
//			return new ModelAndView("admin/mangaCategories/addOrEdit", model);
//		}
//		
//		model.addAttribute("message", "Category is not existed");
//		
//		return new ModelAndView("forward:/admin/mangaCategories/addOrEdit", model);
//	}
	
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model,
			@PathVariable("categoryId") Long categoryId) {
		
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Category is deleted");
		return new ModelAndView("forward:/admin/mangaCategories/search", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("mangaCategory") MangaCategoryDto dto) {
		
		MangaCategory entity=new MangaCategory();
		BeanUtils.copyProperties(dto, entity);
		
		Category category=new Category();
		category.setCategoryId(dto.getCategoryId());
		entity.setCategory(category);
		
		Manga manga=new Manga();
		manga.setMangaId(dto.getMangaId());
		entity.setManga(manga);
		
		mangaCategoryService.save(entity);
		model.addAttribute("message", " is saved");
		return new ModelAndView("forward:/admin/mangaCategories", model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<MangaCategory> list = mangaCategoryService.findAll();
		String k="";
		model.addAttribute("mangaCategories", list);
		return "admin/mangaCategories/list";
	}
	
	

}










