import smtplib
from email.mime.text import MIMEText
import sys

sender = "dealershipsystem@gmail.com"
password = "myToken"
# file okuma

def send_email(subject, body, recipients):
    msg = MIMEText(body)
    msg['Subject'] = subject
    msg['From'] = sender
    msg['To'] = ''.join(recipients)
    with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp_server:
       smtp_server.login(sender, password)
       smtp_server.sendmail(sender, recipients, msg.as_string())
  

send_email(sys.argv[1], sys.argv[2], sys.argv[3])