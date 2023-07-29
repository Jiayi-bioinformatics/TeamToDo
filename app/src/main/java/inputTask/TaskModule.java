package inputTask;

public class TaskModule {
    int img ;
    String title,detail;


    public TaskModule(int img, String title,String detail){
        this.title = title;
        this.detail = detail;
        this.img = img;
    };
    public TaskModule( String title,String detail){
        this.title = title;
        this.detail = detail;

    };
}
