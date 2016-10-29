package api ;

import gumball.*;
import gumball.GumballMachine;
import org.restlet.ext.jackson.*;
import org.restlet.ext.json.*;
import org.restlet.representation.*;
import org.restlet.resource.*;

import java.io.IOException;

public class GumballResource extends ServerResource {

    GumballMachine machine = GumballMachine.getInstance() ;

    @Get
    public Representation get_request() {

        String banner = machine.toString() ;
        int count = machine.getCount() ;
        String state = machine.getStateString() ;


        GumballJackson gb = new GumballJackson();
        gb.setBanner(banner);
        gb.setCount(count);
        gb.setState(state);
        System.out.println("banner is "+ banner);
        return new JacksonRepresentation<GumballJackson>(gb) ;
    }


    /**
     *
     * @param rep action:string,
     * @return
     */
    @Put
    public void put_request(Representation rep) throws IOException {

        JacksonRepresentation<GumballJackson> gumballRep = new JacksonRepresentation<GumballJackson> (rep, GumballJackson.class);
    GumballJackson gb = gumballRep.getObject();
        System.out.print( gb ) ;

//        String action = gb.getString("action") ;
//        System.out.println( "action: " + action ) ;
//
//        if ( action.equals( "insert-quarter") )
//            machine.insertQuarter() ;
//        if ( action.equals( "turn-crank") )
//            machine.turnCrank();
//
//        JSONObject response = new JSONObject() ;
//        String state = machine.getStateString() ;
//        response.put( "result", state ) ;



    }
}

