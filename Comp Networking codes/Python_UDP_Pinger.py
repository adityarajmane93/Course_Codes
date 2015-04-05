# author_rohan_deshmukh

# udp_pinger_python_client

import time
from socket import *

clientSocket = socket(AF_INET, SOCK_DGRAM)
npings = 10
x = 0
print '******Sending 10 pings to server.....********'

while x < npings:
x += 1
curr_Time = time.localtime()
new_Time = time.strftime("%M:%S", curr_Time)
pingMsg = 'Ping %d %s' %(x, new_Time)
start = time.time()
clientSocket.sendto(pingMsg, ('localhost',12000))
clientSocket.settimeout(1)
try:
msgReturn,serverIP = clientSocket.recvfrom(1024)
print msgReturn
rtt = (time.time()-start)
print 'Round Trip Time: ', rtt, '\n\n'
except timeout:
print 'Sorry! Request timed out\n\n'
clientSocket.close()
