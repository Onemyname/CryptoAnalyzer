package ru.javarush.cryptoanalyzer.konovalov.view;



import java.util.Arrays;
import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;
import ru.javarush.cryptoanalyzer.konovalov.entity.Result;
import ru.javarush.cryptoanalyzer.konovalov.entity.ResultCode;
import static ru.javarush.cryptoanalyzer.konovalov.view.Messages.ERROR_FORMAT;
import static ru.javarush.cryptoanalyzer.konovalov.view.Messages.OK_FORMAT;


public class ConsoleApp {
    private MainController mainController;
    private Menu menu;

    public ConsoleApp(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }


    public void run(String[] args) {

        Result result;

        do {
            if (args.length == 0) {
                args = menu.getArgs();
            }

            result = getResult(args);

            print(result);

            args = new String[0];

        }
        while (result.RESULT_CODE == ResultCode.ERROR);


    }


    private Result getResult(String[] args) {
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.doAction(action, parameters);
    }

    private void print(Result result) {
        String message = switch (result.RESULT_CODE) {
            case OK -> String.format(OK_FORMAT, result.MESSAGE);
            case ERROR -> String.format(ERROR_FORMAT, result.MESSAGE);
        };
        System.out.println(message);
    }
}
