package com.fag.sistema.domain.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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

            DecimalFormat format = new DecimalFormat("0.00");
            format.setRoundingMode(RoundingMode.DOWN);

            boolean eightPercentDiscount = salarioBruto.compareTo(new BigDecimal("1751.81")) <= 0;

            boolean ninePercentDiscount = salarioBruto.compareTo(new BigDecimal("1751.82")) >= 0
                    && salarioBruto.compareTo(new BigDecimal("2919.72")) <= 0;

            boolean elevenPercentDiscount = salarioBruto.compareTo(new BigDecimal("2919.73")) >= 0
                    && salarioBruto.compareTo(new BigDecimal("5839.45")) <= 0;

            BigDecimal discountValue = new BigDecimal("642.34");

            if (eightPercentDiscount) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.08"));
            }

            if (ninePercentDiscount) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.09"));
            }

            if (elevenPercentDiscount) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.11"));
            }

            return discountValue.setScale(2, RoundingMode.DOWN).floatValue();
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
