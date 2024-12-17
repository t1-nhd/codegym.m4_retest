package codegym.m4_retest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSP;
    private String tenSP;
    private int giaSP;
    private String tinhTrangSP;
    @ManyToOne
    @JoinColumn(name = "maLoaiSP")
    private LoaiSanPham loaiSanPham;

    @OneToMany(mappedBy = "sanPham")
    private List<DonHang> donHangs;
}
