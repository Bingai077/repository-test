package cn.bingai.practice01.demo02.chapter12_Generic.test2_exer;

class MyDate /*implements Comparable*/ {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

//        @Override
//        public int compareTo(Object o) {
//            if (o instanceof Employee) {
//                Employee e = (Employee) o;
//                if (this.getYear() != e.getBirthday().getYear()) {
//                    return Integer.compare(this.getYear(), e.getBirthday().getYear());
//                } else if (this.getMonth() != e.getBirthday().getMonth()) {
//                    return Integer.compare(this.getMonth(),e.getBirthday().getMonth());
//                } else {
//                    return Integer.compare(this.getDay(), e.getBirthday().getDay());
//                }
//            } else {
//                throw new RuntimeException("输入数据类型不匹配！");
//            }
//        }
}