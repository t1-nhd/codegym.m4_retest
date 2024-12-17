package codegym.m4_retest.service;

import codegym.m4_retest.model.DonHang;
import codegym.m4_retest.model.DonHangDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDonHangService {
    Page<DonHang> findAll(Pageable pageable);
    DonHang findById(Long id);
    void save(DonHang donHang);
    List<DonHangDTO> topDoanhThu(int top);
}
