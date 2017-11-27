package com.xiaonian.core.constanst;

/**
 * Created by ryan on 16/3/14.
 */
public class Status {

    public enum UserStatus{

        NoValidate(1),

        /**
         *
         *
         * */
        FREEZON(0);



        Integer value;
        UserStatus(Integer value){
            this.value = value;
        }
        public Integer value(){
            return this.value;
        }
    }
}
