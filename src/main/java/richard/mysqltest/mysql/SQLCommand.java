package richard.mysqltest.mysql;

public class SQLCommand {
    private String command;
    private Boolean isReturning;
    private ReturnHandler handler;

    public SQLCommand(String command, ReturnHandler returnHandler) {
        this.isReturning = true;
        this.command = command;
        this.handler = returnHandler;
    }

    public SQLCommand(String command) {
        this.isReturning = false;
        this.command = command;
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
