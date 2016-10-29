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

        GumballJackson gb = new GumballJackson();
        gb.setBanner(machine.toString());
        gb.setCount(machine.getCount());
        gb.setState(machine.getStateString());
        System.out.println("banner is "+ machine.toString());
        return new JacksonRepresentation<GumballJackson>(gb) ;
    }


    /**
     *
     * @param rep action:string,
     * @return
     */
    @Post
    public void post_request(Representation rep) throws IOException {

        JacksonRepresentation<GumballAction> gumballAction = new JacksonRepresentation<GumballAction> (rep, GumballAction.class);
        GumballAction gb = gumballAction.getObject();

        String action = gb.getAction();
        System.out.println( "action: " + action ) ;

        if ( action.equals( "insert-quarter") ){
            machine.insertQuarter() ;
            System.out.println( "numQuarters: " + machine.quarters ) ;
        }


        if ( action.equals( "turn-crank") ){
            machine.turnCrank();
            System.out.println( "-numQuarters: " + machine.quarters ) ;

        }



        System.out.println("machine " + machine.toString());
//        JSONObject response = new JSONObject() ;
//        String state = machine.getStateString() ;
//        response.put( "result", state ) ;



    }
}

