package board.service;


import board.board.dto.OnlineMailDto;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailService {

    public void send(OnlineMailDto onlineMailDto){
        try {
            log.info("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
            //연습을 위한 Access, Secret Key를 Static처리
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("AWSAccessKeyId", "AWSSecretKey");
            AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(awsCreds);

            try {
                credentialsProvider.getCredentials();
            } catch (Exception e){
                throw new AmazonClientException(
                        "Cannot load the credentials from the credential profiles file. " +
                                "Please make sure that your credentials file is at the correct " +
                                "location (~/.aws/credentials), and is in valid format.",
                        e);
            }

            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(credentialsProvider)
                    //본인이 AWS 가입 시 배정받은 지역코드 입력
                    // https://docs.aws.amazon.com/general/latest/gr/ses.html 참조 / 나는 Ohio로 배정되어 east-2로 사용
                    .withRegion("us-east-2")
                    .build();

            //Send the email.
            client.sendEmail(onlineMailDto.toSendRequestDto());
            log.info("Email Sent!");

        } catch (Exception ex) {
            log.error("The email was not sent.");
            log.error("Error message: " + ex.getMessage());
            throw new AmazonClientException(
                    ex.getMessage(),
                    ex);
        }

    }

}
