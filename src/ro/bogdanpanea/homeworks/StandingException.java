package ro.bogdanpanea.homeworks;

public class StandingException extends Exception {

    private String errCode;

    StandingException(String message, String err) {

        super(message);
        this.errCode = err;
    }

    public String getErrCode() {
        return errCode;
    }

}