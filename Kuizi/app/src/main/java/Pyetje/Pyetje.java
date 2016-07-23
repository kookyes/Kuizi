package Pyetje;

public class Pyetje {
    private int mTextResourceId;
    private boolean mPergjigjaSakte;

    public Pyetje(int textResourceId, boolean pergjigjaSakte) {
        this.mTextResourceId = textResourceId;
        this.mPergjigjaSakte = pergjigjaSakte;
    }

    public int getTextResourceId(){return mTextResourceId;}

    public void setTextResourceId(int textResourceId){mTextResourceId = textResourceId;}

    public boolean getPergjigjaSakte(){return mPergjigjaSakte;}

    public void setPergjigjaSakte(boolean pergjigjaSakte){mPergjigjaSakte = pergjigjaSakte;}
}
