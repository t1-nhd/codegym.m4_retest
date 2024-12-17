package codegym.m4_retest.controller;


import codegym.m4_retest.model.DonHang;
import codegym.m4_retest.repository.ILoaiSanPhamRepository;
import codegym.m4_retest.repository.ISanPhamRepository;
import codegym.m4_retest.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class DonHangController {
    @Autowired
    IDonHangService donHangService;
    @Autowired
    ISanPhamRepository sanPhamRepository;
    @Autowired
    ILoaiSanPhamRepository loaiSanPhamRepository;

    @GetMapping
    public String index(Model model,
                        @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("donHangs", donHangService.findAll(pageable));
        model.addAttribute("pageTitle", "Đơn hàng");
        return "don_hang/index";
    }

    @GetMapping("/top")
    public String top(@RequestParam("top") int top, Model model) {
        model.addAttribute("donHangs", donHangService.topDoanhThu(top));
        return "don_hang/top";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        DonHang donHang = donHangService.findById(id);
        model.addAttribute("donHang", donHang);
        model.addAttribute("loaiSanPhams", loaiSanPhamRepository.findAll());
        model.addAttribute("sanPhams", sanPhamRepository.findAll());
        model.addAttribute("pageTitle", "Sửa hóa đơn " + id);
        return "don_hang/edit";
    }

    @PostMapping("/update")
    public String update(DonHang donHang, Model model) {
        donHangService.save(donHang);
        model.addAttribute("pageTitle", "Top đơn hàng");
        return "redirect:/" + donHang.getMaDonHang() + "/edit";
    }
}
