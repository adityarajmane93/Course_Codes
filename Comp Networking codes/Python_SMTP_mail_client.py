from socket import *
import ssl
import base64

msg = "\r\n I love computer networks!"
endmsg = "\r\n.\r\n"

# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = "smtp.gmail.com"
port = 465
#username = "rohansmtptest@gmail.com"
#password = "SMTPTest"

# Create socket called clientSocket and establish a TCP connection with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)
ssl_clientSocket = ssl.wrap_socket(clientSocket)
ssl_clientSocket.connect((mailserver, port))

recv = ssl_clientSocket.recv(1024)
print "Connection Request"
print recv

# If the first three numbers of what we receive from the SMTP server are not
# '220', we have a problem
if recv[:3] != '220':
    print '220 reply not received from server.'

# Send HELO command and print server response.
ehloCommand = 'HELO Alice\r\n'
ssl_clientSocket.send(ehloCommand)
recv1 = ssl_clientSocket.recv(1024)
print "Hello"
print recv1

# If the first three numbers of the response from the server are not
# '250', we have a problem
if recv1[:3] != '250':
    print '250 reply not received from server.'
else:
    print 'Hello command was responded by server '


authCommand = 'AUTH LOGIN \r\n'
ssl_clientSocket.send(authCommand)
ssl_clientSocket.send(base64.b64encode('rohansmtptest@gmail.com') + '\r\n')
ssl_clientSocket.send(base64.b64encode('SMTPTest') + '\r\n')



# Send MAIL FROM command and print server response.
mailFromCommand = 'MAIL From: <rohansmtptest@gmail.com>\r\n'
ssl_clientSocket.send(mailFromCommand)
recv2 = ssl_clientSocket.recv(1024)
print "Mail From"
print recv2


# If the first three numbers of the response from the server are not
# '250', we have a problem
if recv2[:3] != '250':
    print '250 reply not received from server.'

# Send RCPT TO command and print server response.
rcptToCommand = 'RCPT To: <rohan.deshmukh@nyu.edu>\r\n'
ssl_clientSocket.send(rcptToCommand)
recv3 = ssl_clientSocket.recv(1024)
print "Mail To"
print recv3


# Send DATA command and print server response.
dataCommand = 'DATA\r\n'
ssl_clientSocket.send(dataCommand)
recv4 = ssl_clientSocket.recv(1024)
print "Data is " + dataCommand
print recv4

# If the first three numbers of the response from the server are not
# '250', we have a problem

# Send message data.
ssl_clientSocket.send(msg)

# Message ends with a single period.
ssl_clientSocket.send(endmsg)

# Send QUIT command and get server response.
quitCommand = 'QUIT\r\n'
ssl_clientSocket.send(quitCommand)
recv5 = ssl_clientSocket.recv(1024)
print "Quiting"
print recv5

# If the first three numbers of the response from the server are not
# '250', we have a problem