/**
 * Created by staho on 12.03.2017.
 */
public enum StudentType {
    STATIONARY {
        @Override
        public String toString() {
            return "stationary";
        }
    },
    NONSTATIONARY {
        @Override
        public String toString(){
            return "nonstationary";
        }
    },
    POSTGRADUATE {
        @Override
        public  String toString(){
            return "postgraduate";
        }
    };
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}

