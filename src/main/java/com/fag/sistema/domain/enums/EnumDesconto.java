package com.fag.sistema.domain.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum EnumDesconto {
    CONTRIBUICAO_SINDICAL {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            return new BigDecimal("50").setScale(2, RoundingMode.DOWN).floatValue();
        }
    },
    VALE_ALIMENTACAO {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            return salarioBruto.multiply(new BigDecimal("0.15")).setScale(2, RoundingMode.DOWN).floatValue();
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
    IRRF {
        @Override
        public Float calculate(BigDecimal salarioBruto) {
            boolean sevenAndHalfPercent = salarioBruto.compareTo(new BigDecimal("1903.99")) >= 0
                    && salarioBruto.compareTo(new BigDecimal("2826.65")) <= 0;

            boolean fifthteenPercent = salarioBruto.compareTo(new BigDecimal("2826.66")) >= 0
                    && salarioBruto.compareTo(new BigDecimal("3751.05")) <= 0;

            boolean twentyTwoAndHalfPercent = salarioBruto.compareTo(new BigDecimal("3751.06")) >= 0
                    && salarioBruto.compareTo(new BigDecimal("4664.68")) <= 0;

            boolean twentySevenAndHalfPercent = salarioBruto.compareTo(new BigDecimal("4664.68")) >= 0;

            BigDecimal discountValue = new BigDecimal("0");

            if (sevenAndHalfPercent) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.075"));
            }

            if (fifthteenPercent) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.15"));
            }

            if (twentySevenAndHalfPercent) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.225"));
            }

            if (twentyTwoAndHalfPercent) {
                discountValue = salarioBruto.multiply(new BigDecimal("0.275"));
            }

            return discountValue.setScale(2, RoundingMode.DOWN).floatValue();
        }
    };

    public abstract Float calculate(BigDecimal salarioBruto);
}
