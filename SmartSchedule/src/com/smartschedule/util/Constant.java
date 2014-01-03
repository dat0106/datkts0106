package com.smartschedule.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smartschedule.R;

public class Constant {
    // CODE
    public static final int SOUND_MANAGER_REQUEST_CODE =  10000;

    // KEY
    public static final String START_OR_END = "start_or_end";
    public static final String ACTION_START_ID_KEY =  "action_start_id_key";
    public static final String ACTION_END_ID_KEY =  "action_end_id_key";

    public static final String ACTION_PARAMS = "action_params";


    public static final  HashMap<Integer,Router>  router = router();

    private static HashMap<Integer,Router> router() {
        HashMap<Integer,Router> router =new HashMap<Integer, Router>();

        Router r = new Router();
        r.id = 1;
        r.name = R.string.app_name;
        r.iconURI =  R.drawable.ic_launcher;
        r.category = 1;

        router.put(1, r);
        return router;
    }
}
