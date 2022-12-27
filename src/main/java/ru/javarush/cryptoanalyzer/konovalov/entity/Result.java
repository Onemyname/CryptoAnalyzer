package ru.javarush.cryptoanalyzer.konovalov.entity;

public class Result {



    public final ResultCode RESULT_CODE;
    public final  String MESSAGE;

    public Result(ResultCode resultCode, String message) {
        this.RESULT_CODE = resultCode;
        this.MESSAGE = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + RESULT_CODE +
                ", message='" + MESSAGE + '\'' +
                '}';
    }
}
