package com.davis.time.constant;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TimeConstant {
	 /**
     * �� JDK1.5 �H�W �~�i�H�ϥ�
     * 
     */
    public interface DateStringFormat {
        /**
         * Use: String.format(%xx, date)
         * <p>
         * show: 20121018
         */
        public final String yyyyMMdd = "%1$tY%1$tm%1$td";

        /**
         * Use: String.format(%xx, date)
         * <p>
         * tL-�����@��
         * <p>
         * show: 20121018_10:55:47_405
         */
        public final String yyyyMMddHHmmssl0 = "%1$tY%1$tm%1$td_%1$tH:%1$tM:%1$tS_%1$tL";

        /**
         * Use: String.format(%xx, date)
         * <p>
         * tL-�����@��
         * <p>
         * show: 20121018_105547405
         */
        public final String yyyyMMddHHmmssl1 = "%1$tY%1$tm%1$td_%1$tH%1$tM%1$tS%1$tL";

        /**
         * Use: String.format(%xx, date)
         * <p>
         * show: 2012-10-18-105547
         */
        public final String yyyyMMddHHmmss0 = "%1$tY-%1$tm-%1$td-%1$tH%1$tM%1$tS";

        /**
         * Use: String.format(%xx, date)
         * <p>
         * tb -- �S�w��y�����Ҫ����²��
         * <p>
         * ta -- �S�w��y�����Ҫ��P���X²��
         * <p>
         * show: 2012/01/23-[ �@�� ]-[ �P���@ ]
         */
        public final String yyyyMMddba = "%1$tY/%1$tm/%1$td-[ %1$tb ]-[ %1$ta ]";
    }

    public enum NumberFormatType {
        IntegerRound(new DecimalFormat("##"), RoundingMode.HALF_EVEN);
        private DecimalFormat format;

        NumberFormatType(DecimalFormat a, RoundingMode r) {
            this.format = a;
            a.setRoundingMode(r);
        }

        public String getNumber(long qty) {
            return this.format.format(qty);
        }

        public String getNumber(double qty) {
            return this.format.format(qty);
        }
    }
}
