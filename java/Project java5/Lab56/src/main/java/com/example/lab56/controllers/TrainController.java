package com.example.lab56.controllers;

import com.example.lab56.entities.Train;
import com.example.lab56.entities.TrainType;
import com.example.lab56.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainController {
    @Autowired
    private TrainService service;
    // show train with pagination

    @GetMapping("/train")
    public String showAllTrain(Model model) {
        List<Train> train = service.getAllTrains();
        model.addAttribute("trains", train);
//        List<TrainType> trainType = Arrays.asList(TrainType.values());
        model.addAttribute("type", TrainType.values());
        return "train-list";
    }
    @GetMapping("/train/add")
    public String showForm(Model model) {
        model.addAttribute("train", new Train());
        model.addAttribute("type", TrainType.values());
        return "train-form";
    }

    @PostMapping("/train/save")
    public String saveTrain(Train train) {
        service.saveTrain(train);
        return "redirect:/train";
    }
    @GetMapping("/train/edit/{id}")
    public String showEditForm(@PathVariable("id") Train train, Model model) {
//        Optional<Train> train = service.getTrainById(id);
        TrainType[] types = TrainType.values();
        System.out.println(types[0]);
        model.addAttribute("train", train);
        model.addAttribute("type", TrainType.values());

        return "train-form";
    }
    @GetMapping("/train/delete/{id}")
    public String deleteTrain(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/train";
    }
    @GetMapping("/train/delete/ids")
    public String deleteTrain(@RequestParam(name="ids") List<Integer> ids) {
         service.deleteAll(ids);
        return "redirect:/train";
    }
    @GetMapping("/train/{type}")
    public String searchTrain(@RequestParam(name="type") TrainType type, Model model) {
        List<Train> train = service.getTrainByType(type);
        model.addAttribute("trains", train);
        model.addAttribute("type", TrainType.values());
        return "train-list";
    }
//    @GetMapping("/train/page/{pageNumber}")
//    public String showTrain(HttpServletRequest request,
//                            @PathVariable int pageNumber, Model model) {
//        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("train");
//        int pagesize = 3;
//        List<Train> list =(List<Train>) service.getAllTrains();
//        System.out.println(list.size());
//        if (pages == null) {
//            pages = new PagedListHolder<>(list);
//            pages.setPageSize(pagesize);
//        } else {
//            final int goToPage = pageNumber - 1;
//            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
//                pages.setPage(goToPage);
//            }
//        }
//        request.getSession().setAttribute("train", pages);
//        int current = pages.getPage() + 1;
//        int begin = Math.max(1, current - list.size());
//        int end = Math.min(begin + 5, pages.getPageCount());
//        int totalPageCount = pages.getPageCount();
//        String baseUrl = "/train/page/";
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);
//        model.addAttribute("totalPageCount", totalPageCount);
//        model.addAttribute("baseUrl", baseUrl);
//        model.addAttribute("train", pages);
//        return "train-list";
//    }
}
