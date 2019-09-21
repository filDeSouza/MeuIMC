package br.com.digitalhouse.meuimc.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Operacional implements Parcelable {
    private Integer imagem;
    private String texto;

    public Operacional(Integer imagem, String texto) {
        this.imagem = imagem;
        this.texto = texto;
    }

    protected Operacional(Parcel in) {
        if (in.readByte() == 0) {
            imagem = null;
        } else {
            imagem = in.readInt();
        }
        texto = in.readString();
    }

    public static final Creator<Operacional> CREATOR = new Creator<Operacional>() {
        @Override
        public Operacional createFromParcel(Parcel in) {
            return new Operacional(in);
        }

        @Override
        public Operacional[] newArray(int size) {
            return new Operacional[size];
        }
    };

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (imagem == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(imagem);
        }
        parcel.writeString(texto);
    }
}
