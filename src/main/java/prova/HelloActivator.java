package prova;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Used to bootstrap JAX-RS.  Otherwise this class is
 * not directly used.
 *
 */
@ApplicationPath("/rest")
public class HelloActivator extends Application {
    // intentionally empty
}