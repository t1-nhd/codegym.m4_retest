package codegym.m4_retest.service.impl;

import codegym.m4_retest.model.DonHang;
import codegym.m4_retest.model.DonHangDTO;
import codegym.m4_retest.repository.IDonHangRepository;
import codegym.m4_retest.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService implements IDonHangService {
    @Autowired
    private IDonHangRepository donHangRepository;

    @Override
    public Page<DonHang> findAll(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }

    @Override
    public void save(DonHang donHang) {
        donHangRepository.save(donHang);
    }

    @Override
    public List<DonHangDTO> topDoanhThu(int top) {
        return donHangRepository.topDoanhThu(top);
    }

    @Override
    public DonHang findById(Long id) {
        return donHangRepository.findById(id).get();
    }
}
