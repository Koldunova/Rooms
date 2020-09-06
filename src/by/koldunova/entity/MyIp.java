package by.koldunova.entity;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;

public class MyIp extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String ip;
    private String country;

    public MyIp(HttpServletRequest req) {
        setClientIp(req);
        setClientCountry();
    }

    private void setClientCountry() {

        String dbLocation = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\testingapp\\WEB-INF\\classes\\by\\koldunova\\res/GeoLite2-Country.mmdb";

        File database = new File(dbLocation);

        try {
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = dbReader.country(ipAddress);

            this.country = response.getCountry().getName();
        } catch (UnknownHostException e) {
            country="не определена - UnknownHostException";
        } catch (IOException e) {
            country="не определена - IOException";
        } catch (GeoIp2Exception e) {
            country="не определена - GeoIp2Exception";
        }

    }

    private void setClientIp(HttpServletRequest request) {
        if (request != null) {
            this.ip = request.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                this.ip = request.getRemoteAddr();
            }
        }

        this.ip = "178.126.244.4";
    }

    public String getIp() {
        return ip;
    }

    public String getCountry() {
        return country;
    }

}
