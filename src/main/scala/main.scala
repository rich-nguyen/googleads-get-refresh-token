import com.google.api.ads.common.lib.auth.GoogleClientSecretsBuilder
import com.google.api.ads.common.lib.auth.GoogleClientSecretsBuilder.Api
import com.google.api.ads.common.lib.exception.ValidationException
import org.apache.commons.configuration.BaseConfiguration

import dfp.axis.auth.GetRefreshToken

object Main {

  def main(args: Array[String]) {
    println("-- Welcome to the Get Refresh Token DFP assistant --")
    println()

    print("1. Network code please: ")
    val networkCode = Console.readLine()

    print("2. Client ID please: ")
    val clientID = Console.readLine()

    print("3. Client secret please: ")
    val clientSecret = Console.readLine()

    print("4. Application name please: ")
    val applicationName = Console.readLine()

    println("\nThanks.\nComputerising refresh token...\n")

    try {
        val config = new BaseConfiguration()

        config.setProperty("api.dfp.networkCode", networkCode)
        config.setProperty("api.dfp.clientId", clientID)
        config.setProperty("api.dfp.clientSecret", clientSecret)
        config.setProperty("api.dfp.applicationName", applicationName)

        val clientSecrets = new GoogleClientSecretsBuilder()
          .forApi(Api.DFP)
          .from(config)
          .build();

        // Get the OAuth2 credential.
        val credential = GetRefreshToken.getOAuth2Credential(clientSecrets);

        System.out.printf("Your refresh token is: %s%n", credential.getRefreshToken());
    } catch {
      case e: ValidationException => {
        System.err.println(
          s"Validation error: ${e.getMessage}")
      }
    }

  }

  // public static void main(String[] args) throws Exception {
  //   // Get the client ID and secret from the ads.properties file.
  //   // If you do not have a client ID or secret, please create one in the
  //   // API console: https://console.developers.google.com/project and set it
  //   // in the ads.properties file.
  //   GoogleClientSecrets clientSecrets = null;
  //   try {
  //     clientSecrets = new GoogleClientSecretsBuilder()
  //         .forApi(Api.DFP)
  //         .fromFile()
  //         .build();
  //   } catch (ValidationException e) {
  //     System.err.println(
  //         "Please input your client ID and secret into your ads.properties file, which is either "
  //         + "located in your home directory in your src/main/resources directory, or "
  //         + "on your classpath. If you do not have a client ID or secret, please create one in "
  //         + "the API console: https://console.developers.google.com/project");
  //     System.exit(1);
  //   }

  //   // Get the OAuth2 credential.
  //   Credential credential = getOAuth2Credential(clientSecrets);

  //   System.out.printf("Your refresh token is: %s%n", credential.getRefreshToken());

  //   // Enter the refresh token into your ads.properties file.
  //   System.out.printf("In your ads.properties file, modify:%n%napi.dfp.refreshToken=%s%n",
  //       credential.getRefreshToken());
  // }
}