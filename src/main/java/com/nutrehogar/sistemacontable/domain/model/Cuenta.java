package com.nutrehogar.sistemacontable.domain.model;

import java.math.BigDecimal;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cuenta")

public class Cuenta {
    @Id
    @Column(name = "id", columnDefinition = "TEXT")
    String id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column(name = "saldo", precision = 15, scale = 2)
    BigDecimal saldo;
    
    @OneToOne
    @JoinColumn(name = "id_tipo_cuenta", nullable = false)
    TipoCuenta tipoCuenta;

    @OneToOne
    @JoinColumn(name = "id_subtipo_cuenta", nullable = false)
    SubtipoCuenta subtipoCuenta;
    
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Registro> asientos = new ArrayList<>();
}
