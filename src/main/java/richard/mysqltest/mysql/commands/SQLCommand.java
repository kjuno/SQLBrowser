package richard.mysqltest.mysql.commands;

import richard.mysqltest.mysql.handler.ReturnHandler;

public class SQLCommand {
    private String command;
    private Boolean isReturning;
    private ReturnHandler handler;
    private Object[] data;

    public SQLCommand(String command, ReturnHandler returnHandler) {
        this.isReturning = true;
        this.command = command;
        this.handler = returnHandler;
    }

    public SQLCommand(String command) {
        this.isReturning = false;
        this.command = command;
    }

    public SQLCommand() {
    }

    public void setHandler(ReturnHandler handler) {
        this.handler = handler;
    }

    public String getCommand() {
        return command;
    }

    public Boolean isReturning() {
        return isReturning;
    }

    public ReturnHandler getHandler(){
        return handler;
    }
}
