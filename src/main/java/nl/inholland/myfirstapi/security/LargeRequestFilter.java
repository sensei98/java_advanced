package nl.inholland.myfirstapi.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Log
@Component
@Order(1)
public class LargeRequestFilter implements Filter {

//    @Value("{guitarshop.api.max.request.size}")
    private int maxSize = 1000000;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//            log.info(String.format("Max Request size: %d",maxSize));
        int size = request.getContentLength();
        log.info(String.format("Request size: %d", size));
        if(size > maxSize){
            log.info(String.format("Request too large, was size %d" , size));
            throw new ServletException("Rejected request because it was too large");
        }
        else{
            chain.doFilter(request,response);
        }


    }
}
