package quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @PostConstruct
    public void Init() {
        System.out.println(repeat);
        System.out.println("Phase 2");
    }


    public TerminatorQuoter() {System.out.println("Phase 1");}

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + this.message);
        }
    }
}
