package de.kjuno.sqlbrowser.mysql.commands;

import de.kjuno.sqlbrowser.mysql.handler.ReturnHandler;

public class SQLCommand {
    private final String command;
    private final Boolean isReturning;
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
