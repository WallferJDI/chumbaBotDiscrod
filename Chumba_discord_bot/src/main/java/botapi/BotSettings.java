package botapi;

public class BotSettings {
    private boolean writeBySelf= true;
    private int interval = 10;
    public boolean getWriteBySelf(){
        return writeBySelf;
    }
    public void setWriteBySelf(boolean bool){
        writeBySelf = bool;
    }
    public int getInterval(){
        return interval;
    }
    public void setInterval(int num){
        interval = num;
    }


    public String getSettingsInfo() {
        return "BotSettings{" +
                "writeBySelf=" + writeBySelf +
                ", interval=" + interval +
                '}';
    }
}
