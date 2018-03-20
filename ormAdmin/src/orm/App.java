package orm;


import orm.vue.VueOrm;

public class App {

    public static void main(String[] parametres) {

        VueOrm vueOrm = new VueOrm(0);
        vueOrm.launch(VueOrm.class, parametres);


    }

}
