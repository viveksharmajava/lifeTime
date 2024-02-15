package security;


import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;

public class ListSecurityProviders
{
  public static void main(String[] args)
  {
    Provider [] providerList = Security.getProviders();
    int i=1;
    for (Provider provider : providerList)
     {
       System.out.println("security.provider."+i+" = Name: "  + provider.getName());
       i++;
     //  System.out.println("Information:\n" + provider.getInfo());

       Set<Service> serviceList = provider.getServices();
       for (Service service : serviceList)
        {
         //.out.println("Service Type: " + service.getType() + " Algorithm " + service.getAlgorithm());
        }
     }
  }
}