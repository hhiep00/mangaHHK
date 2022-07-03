package com.pro.manga.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.Category;
import com.pro.manga.domain.Chapter;
import com.pro.manga.domain.Favourite;
import com.pro.manga.domain.Manga;
import com.pro.manga.domain.MangaCategory;
import com.pro.manga.domain.PageManga;
import com.pro.manga.domain.Read;
import com.pro.manga.domain.User;
import com.pro.manga.model.MangaDto;
import com.pro.manga.model.UserDto;
import com.pro.manga.service.CategoryService;
import com.pro.manga.service.ChapterService;
import com.pro.manga.service.FavouriteService;
import com.pro.manga.service.MangaCategoryService;
import com.pro.manga.service.MangaService;
import com.pro.manga.service.PageService;
import com.pro.manga.service.ReadMangaService;
import com.pro.manga.service.UserService;

@Controller
@RequestMapping("manga")
public class MangaUserController {
	@Autowired
	MangaService mangaService;

	@Autowired
	ChapterService chapterService;
	
	@Autowired
	ReadMangaService readMangaService;
	
	@Autowired
	PageService pageService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FavouriteService favouriteService;
	
	@Autowired
	MangaCategoryService mangaCategoryService;
	
	@GetMapping("{mangaId}")
	public ModelAndView discriptionManga(ModelMap model, @PathVariable("mangaId") Long mangaId) {
		Optional<Manga> opt = mangaService.findById(mangaId);
		List<MangaCategory> listCategories=new ArrayList<>();
		List<Chapter> listChapters=new ArrayList<>();
		MangaDto dto=new MangaDto();
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println(username);
		
		boolean checkLogin=true;
		if(username.equals("anonymousUser"))
			checkLogin=false;
		model.addAttribute("check", checkLogin);
		if(opt.isPresent()) {
			Manga entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("manga", dto);
			
			listCategories= mangaCategoryService.findByMangaId(mangaId);
			model.addAttribute("listCategories", listCategories);
			model.addAttribute("manga",entity);
			listChapters=chapterService.findChapterByMangaId(mangaId);
			model.addAttribute("chapters", listChapters);
			return new ModelAndView("web/mangas/description", model);
		}
		model.addAttribute("message", "khong co");
		return new ModelAndView("web/home", model);
	}
	
	@GetMapping("{mangaId}/{numberOfChapter}")
	public ModelAndView readManga(ModelMap model, @PathVariable("mangaId") Long mangaId, @PathVariable("numberOfChapter") int numberOfChapter) {
		
		Read entity = new Read();
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user=userService.findByUsername(username).get();
		
		Optional<Chapter> chapter=chapterService.findChapterByMangaIdandNumbrChapter(mangaId, numberOfChapter);
		Manga manga=mangaService.findById(mangaId).get();		
		entity.setUser(user);
		entity.setChapter(chapter.get());
		readMangaService.save(entity);
		
		List<PageManga> listPage = pageService.findAllByChapterId(chapter.get().getChapterId());
		
		model.addAttribute("numberC", numberOfChapter);
		model.addAttribute("manga", manga);
		model.addAttribute("pages", listPage);
		model.addAttribute("message", "khong co");
		return new ModelAndView("web/mangas/read", model);
	}
	
	@PostMapping("favourite/{mangaId}")
	public ModelAndView favouriteManga(ModelMap model, @PathVariable("mangaId") Long mangaId) {
		Favourite entity=new Favourite();
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user=userService.findByUsername(username).get();
		
		
		Manga manga=new Manga();
		Optional<Manga> optManga = mangaService.findById(mangaId);
		if(optManga.isPresent()) {
			manga=optManga.get();
		}
		entity.setManga(manga);
		entity.setUser(user);
		favouriteService.save(entity);
		return new ModelAndView("forward:/web/mangas/description", model);
	}
	@GetMapping("dislike/{mangaId}")
	public String dislikeManga(ModelMap model, @PathVariable("mangaId") Long mangaId) {
		Favourite entity=new Favourite();
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user=userService.findByUsername(username).get();
		
		
		Manga manga=new Manga();
		Optional<Manga> optManga = mangaService.findById(mangaId);
		System.out.println(optManga.isPresent());
		if(optManga.isPresent()) {
			manga=optManga.get();
		}
//		entity.setMang(manga);
//		entity.setUser(user);
		entity=favouriteService.findByMangaIdAndUserId(mangaId, user.getUserId());
		favouriteService.delete(entity);
		return "forward:/web/mangas/favourite";
	}
	@GetMapping("history")
	public ModelAndView historyManga(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println(username);
		Optional<User> opt=userService.findByUsername(username);
		
		List<Read> historyReads=new ArrayList<>();
		if(opt.isPresent()) {
			User user=opt.get();
			historyReads=readMangaService.findAllByUserId(user.getUserId());
			System.out.println(historyReads.size());
			model.addAttribute("historyReads", historyReads);
			return new ModelAndView("web/mangas/history", model);
		}
		
		return new ModelAndView("web/home", model);
	}

	@GetMapping("favourite")
	public ModelAndView favouriteManga(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println(username);
		Optional<User> opt=userService.findByUsername(username);
		
		List<Favourite> favouriteReads=new ArrayList<>();
		if(opt.isPresent()) {
			User user=opt.get();
			favouriteReads=favouriteService.findAllByUserId(user.getUserId());
			System.out.println(favouriteReads.size());
			model.addAttribute("favouriteReads", favouriteReads);
			return new ModelAndView("web/mangas/favourite", model);
		}
		
		return new ModelAndView("web/home", model);
	}
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("category/{categoryName}")
	public ModelAndView discriptionManga(ModelMap model, @PathVariable("categoryName") String categoryName) {
		Category category=categoryService.findByName(categoryName);
		List<MangaCategory> lists=new ArrayList<>();
		
		lists=mangaCategoryService.findByCategoryId(category.getCategoryId());
		
		model.addAttribute("lists", lists);
		
		model.addAttribute("message", "khong co");
		return new ModelAndView("web/mangas/findCategory", model);
	}
	
	
	
	
	
}









