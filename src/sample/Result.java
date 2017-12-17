package sample;

/**
 * Created by diman on 16.12.2017.
 */


public class Result {

    private String name;
    private Integer result;

    public Result(String name, Integer result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
