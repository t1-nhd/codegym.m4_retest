package codegym.m4_retest.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class DonHangDTO {
    private Long maDonHang;
    private LocalDate ngayMua;
    private int soLuong;
    private Long maSP;
    private int giaSP;
    private String tenSP;
    private String tinhTrangSP;
    private String tenLoaiSP;
    private int tongTien;
}
