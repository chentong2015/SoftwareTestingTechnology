package hamcrest;

public class MyHamcrestClass {

    private String name;

    public MyHamcrestClass(String name) {
        this.name = name;
    }

    // override the equals() logical to compare two objects of this type
    @Override
    public boolean equals(Object objCompared) {
        // 比较是对象的引用
        if (this == objCompared) return true;
        if (objCompared == null) return false;
        if (objCompared.getClass() != this.getClass()) return false;

        MyHamcrestClass objectCompared = (MyHamcrestClass) objCompared;
        return name.equals(objectCompared.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
