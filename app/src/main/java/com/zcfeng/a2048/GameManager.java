package com.zcfeng.a2048;

/**
 * Created by Administrator on 2017/8/30/030.
 */

public class GameManager {
    public static int[] merge(int[] rows) {
        int index=0;
        int[] res=new int[4];
        for(int num:rows) {
            if(num>0){
                if(res[index]==0){
                    res[index]+=num;
                }
                else
                if(res[index]==num) {
                    res[index]+=num;
                    index++;
                }
                else{
                    res[++index]=num;
                }
            }
        }
        return res;
    }
    static boolean check(int[] rows,int x,int y) {
        boolean _res=false;
        int index=0;
        if(x<0) {
            index=15;
        }
        for(int i=0;i<4;i++) {
            int[] temp=new int[4];
            for(int j=0;j<4;j++){
                temp[j]= rows[index+j*y];
            }
            int[] res=merge(temp);
            for(int j=0;j<4;j++) {
                if(rows[index+j*y]!=res[j]) {
                    _res=true;
                }
            }
            index+=x;
        }
        return _res;
    }
    static boolean action(int[] rows,int x,int y) {
        boolean _res=false;
        int index=0;
        if(x<0) {
            index=15;
        }
        for(int i=0;i<4;i++) {
            int[] temp=new int[4];
            for(int j=0;j<4;j++){
                temp[j]= rows[index+j*y];
            }
            int[] res=GameManager.merge(temp);
            for(int j=0;j<4;j++) {
                if(rows[index+j*y]!=res[j]) {
                    rows[index + j * y] = res[j];
                    _res=true;
                }
            }
            index+=x;
        }
        return _res;
    }
    public static void addRandom(int[] a) {
        int i=(int) (Math.random()*15);
        int index=0;
        while(a[index%16]!=0)index++;
        for(int j=0;j<i;j++) {
            index++;
            while(a[index%16]!=0)index++;
        }
        a[index%16]=2;
    }
}