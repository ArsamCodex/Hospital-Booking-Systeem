package Hospital.System.controller;

import Hospital.System.model.User;
import Hospital.System.model.bindingModel.DoctorRegistrationModel;
import Hospital.System.model.bindingModel.EditDoctorModel;
import Hospital.System.model.bindingModel.EditDoctorPictureModel;
import Hospital.System.model.viewModel.DoctorViewModel;
import Hospital.System.model.viewModel.SettlePointViewModel;
import Hospital.System.service.DoctorService;
import Hospital.System.service.SettlePointService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


// END PROJECT JAVAEE GRADUATE APPROVED
// A FINISH JOB BUT NOT COMPLETE
//IM GOING TO SHARE PROJECT ON MY PRIVATE WEBPAGE
//IM GOING TO EXPLAIN ASLO WHAT SHOULD HAPPEN TODO`S , FOR ME ITS CLOSED CASE. ~557~




@Controller
//@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService;

    private SettlePointService settlePointService;

    @Autowired
    public DoctorController(DoctorService doctorService, SettlePointService settlePointService) {
        this.doctorService = doctorService;
        this.settlePointService = settlePointService;
    }

    @GetMapping("/doctors/{id}")
    public String getDoctor(@PathVariable long id, Model model) {
        DoctorViewModel doctorViewModel = this.doctorService.getViewModelById(id);

        model.addAttribute("doctorViewModel", doctorViewModel);

        return "doctor/doctor";
    }


    @GetMapping("/doctors")
    public String getDoctors(Model model, @PageableDefault(size = 8) Pageable pageable) {
        Page<DoctorViewModel> doctors = this.doctorService.getAll(pageable);
        model.addAttribute("doctors", doctors);

        return "doctor/doctors";
    }

    @GetMapping("/register-doctor")
    public String getDoctorRegister(@ModelAttribute DoctorRegistrationModel doctorRegistrationModel, Model model) {
        List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
        model.addAttribute("settlePoints", settlePoints);

        return "doctor/register";
    }

    @PostMapping("/register-doctor")
    public String registerDoctor(@Valid @ModelAttribute DoctorRegistrationModel doctorRegistrationModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
            model.addAttribute("settlePoints", settlePoints);

            return "doctor/register";
        }

        this.doctorService.create(doctorRegistrationModel);

        return "redirect:/";
    }

    @GetMapping("/doctor/edit")
    public String getEditDoctor(Model model, Authentication principal) {
        List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
        model.addAttribute("settlePoints", settlePoints);

        long userId = ((User) principal.getPrincipal()).getId();
        EditDoctorModel editDoctorModel = this.doctorService.getEditModelByUserId(userId);

        model.addAttribute("editDoctorModel", editDoctorModel);

        return "doctor/edit";
    }


    //problem
    @PostMapping("/doctor/edit")
    public String editDoctor(@Valid @ModelAttribute EditDoctorModel editDoctorModel, BindingResult bindingResult,
                             Authentication principal, Model model) {
        if (bindingResult.hasErrors()) {
            List<SettlePointViewModel> settlePoints = this.settlePointService.getAll();
            model.addAttribute("settlePoints", settlePoints);

            return "doctor/edit";
        }

        long userId = ((User) principal.getPrincipal()).getId();
        EditDoctorModel editDoctorModelId = this.doctorService.getEditModelByUserId(userId);
        editDoctorModel.setId(editDoctorModelId.getId());

        this.doctorService.save(editDoctorModel);

        return "redirect:/";
    }

    @GetMapping("/doctor/picture")
    public ResponseEntity<EditDoctorPictureModel> getDoctorPicture(Authentication principal) {
        long userId = ((User) principal.getPrincipal()).getId();
        EditDoctorPictureModel editDoctorPictureModel = this.doctorService.getPictureModelByUserId(userId);
        editDoctorPictureModel.setPicturePath("/mm_pics/" + editDoctorPictureModel.getPicturePath());

        return ResponseEntity.ok(editDoctorPictureModel);
    }

    @PostMapping("/doctor/edit-picture")
    @ResponseBody
    public String addPictures(MultipartHttpServletRequest request, Authentication principal) {
        Iterator<String> itr = request.getFileNames();
        String imageFolderPath = "C:/dabs_mm_pics/doctor_pic/";

        MultipartFile picture = request.getFile(itr.next());

        if (picture.isEmpty()) {
            return "Error";
        }

//        this.validateEventPicture(picture);

        //Generating unique random name for the picture so it wouldn't override other with the same name.
        UUID uniquePicName = UUID.randomUUID();
        String imageFormat = FilenameUtils.getExtension(picture.getOriginalFilename());
        String pictureName = uniquePicName + "." + imageFormat;
        String filePath = imageFolderPath + pictureName;
        File dest = new File(filePath);

        try {
            picture.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long userId = ((User) principal.getPrincipal()).getId();
        long doctorId = this.doctorService.getByUserId(userId).getId();

        EditDoctorPictureModel editDoctorPictureModel = new EditDoctorPictureModel();
        editDoctorPictureModel.setId(doctorId);
        editDoctorPictureModel.setPicturePath(pictureName);

        this.doctorService.savePicture(editDoctorPictureModel);

        return "Success";
    }
}