package com.fag.sistema.service;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Proventos;
import com.fag.sistema.domain.usecases.calcular.beneficios.AdicionalInsalubridade;
import com.fag.sistema.domain.usecases.calcular.beneficios.AdicionalNoturno;
import com.fag.sistema.domain.usecases.calcular.beneficios.AdicionalPericulosidade;
import com.fag.sistema.domain.usecases.calcular.beneficios.AuxilioCreche;
import com.fag.sistema.domain.usecases.calcular.beneficios.Comissao;
import com.fag.sistema.domain.usecases.calcular.beneficios.DiariasParaViagem;
import com.fag.sistema.domain.usecases.calcular.beneficios.HorasExtras;
import com.fag.sistema.domain.usecases.calcular.beneficios.Quinquenio;
import com.fag.sistema.domain.usecases.calcular.beneficios.SalarioFamilia;
import com.fag.sistema.domain.usecases.calcular.beneficios.SalarioMaternidade;
import com.fag.sistema.domain.usecases.calcular.descontos.ContribuicaoSindical;
import com.fag.sistema.domain.usecases.calcular.descontos.FGTS;
import com.fag.sistema.domain.usecases.calcular.descontos.INSS;
import com.fag.sistema.domain.usecases.calcular.descontos.IRRF;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeAlimentacao;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeTransporte;

@Service
public class ProventosService {
    private AdicionalInsalubridade adicionalInsalubridade;
    private AdicionalNoturno adicionalNoturno;
    private AdicionalPericulosidade adicionalPericulosidade;
    private AuxilioCreche auxilioCreche;
    private Comissao comissao;
    private DiariasParaViagem diariasParaViagem;
    private HorasExtras horasExtras;
    private Quinquenio quinquenio;
    private SalarioFamilia salarioFamilia;
    private SalarioMaternidade salarioMaternidade;

    private ContribuicaoSindical contribuicaoSindical;
    private FGTS fgts;
    private INSS inss;
    private IRRF irrf;
    private ValeAlimentacao valeAlimentacao;
    private ValeTransporte valeTransporte;

    public ProventosService(AdicionalInsalubridade adicionalInsalubridade, AdicionalNoturno adicionalNoturno, AdicionalPericulosidade adicionalPericulosidade, AuxilioCreche auxilioCreche, Comissao comissao, DiariasParaViagem diariasParaViagem, HorasExtras horasExtras, Quinquenio quinquenio, SalarioFamilia salarioFamilia, SalarioMaternidade salarioMaternidade, ContribuicaoSindical contribuicaoSindical, FGTS fgts, INSS inss, IRRF irrf, ValeAlimentacao valeAlimentacao, ValeTransporte valeTransporte) {
        this.adicionalInsalubridade = adicionalInsalubridade;
        this.adicionalNoturno = adicionalNoturno;
        this.adicionalPericulosidade = adicionalPericulosidade;
        this.auxilioCreche = auxilioCreche;
        this.comissao = comissao;
        this.diariasParaViagem = diariasParaViagem;
        this.horasExtras = horasExtras;
        this.quinquenio = quinquenio;
        this.salarioFamilia = salarioFamilia;
        this.salarioMaternidade = salarioMaternidade;
        this.contribuicaoSindical = contribuicaoSindical;
        this.fgts = fgts;
        this.inss = inss;
        this.irrf = irrf;
        this.valeAlimentacao = valeAlimentacao;
        this.valeTransporte = valeTransporte;
    }

    public Proventos calcularProventos(Empregado empregado){
        Proventos proventos = new Proventos();
        double totalBeneficios = 0.0;
        double totalDescontos = 0.0;

        totalBeneficios += adicionalInsalubridade.calculate(empregado).doubleValue();
        totalBeneficios += adicionalNoturno.calculate(empregado).doubleValue();
        totalBeneficios += adicionalPericulosidade.calculate(empregado).doubleValue();
        totalBeneficios += auxilioCreche.calculate(empregado).doubleValue();
        totalBeneficios += comissao.calculate(empregado).doubleValue();
        totalBeneficios += diariasParaViagem.calculate(empregado).doubleValue();
        totalBeneficios += horasExtras.calculate(empregado).doubleValue();
        totalBeneficios += quinquenio.calculate(empregado).doubleValue();
        totalBeneficios += salarioFamilia.calculate(empregado).doubleValue();
        totalBeneficios += salarioMaternidade.calculate(empregado).doubleValue();

        totalDescontos += contribuicaoSindical.calculate(empregado).doubleValue();
        totalDescontos += fgts.calculate(empregado).doubleValue();
        totalDescontos += inss.calculate(empregado).doubleValue();
        totalDescontos += irrf.calculate(empregado).doubleValue();
        totalDescontos += valeAlimentacao.calculate(empregado).doubleValue();
        totalDescontos += valeTransporte.calculate(empregado).doubleValue();

        proventos.setTotalBeneficios((int) totalBeneficios);
        proventos.setTotalDescontos((int) totalDescontos);

        return proventos;
    }
}
