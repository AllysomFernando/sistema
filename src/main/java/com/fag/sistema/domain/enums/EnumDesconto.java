package com.fag.sistema.domain.enums;

import java.math.BigDecimal;

public enum EnumDesconto {
    CONTRIBUICAO_SINDICAL {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'calculate'");
        }
    },
    VALE_ALIMENTACAO {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'calculate'");
        }
    },
    FGTS {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            return salarioBruto.multiply(new BigDecimal("0.08")).floatValue();
        }
    },
    INSS() {
        @Override
        public Float calculate(BigDecimal salarioBruto) {

            if (salarioBruto.compareTo(BigDecimal.valueOf(1751.81)) < 0) {
                return salarioBruto.multiply(new BigDecimal("0.08")).floatValue();
            }

            if (salarioBruto.compareTo(BigDecimal.valueOf(1751.82)) > 0
                    && salarioBruto.compareTo(BigDecimal.valueOf(2919.72)) < 0) {
                return salarioBruto.multiply(new BigDecimal("0.09")).floatValue();
            }

            if (salarioBruto.compareTo(BigDecimal.valueOf(2919.73)) > 0
                    && salarioBruto.compareTo(BigDecimal.valueOf(5839.45)) < 0) {
                return salarioBruto.multiply(new BigDecimal("0.11")).floatValue();
            }

            return salarioBruto.multiply(new BigDecimal("0.08")).floatValue();
        }
    },
    IRFF {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'calculate'");
        }
    };

    public abstract Float calculate(BigDecimal salarioBruto);
}
