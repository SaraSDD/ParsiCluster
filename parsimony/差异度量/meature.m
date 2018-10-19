clear all
close all

data1 = xlsread('²Ë»¨Â¶Î²¼×Êô.xlsx');
data2 = xlsread('²Ë»¨Â¶Î²¼×Êô2.xlsx');
Sumerror = 0;
for i = 1:size(data1,1)
    for j = 1:size(data1,1)
        if j <= i
            error = data1(i,j) - data2(i,j);
            Sumerror = Sumerror + abs(error);
        end
    end
end

caucle = (Sumerror*2)/(size(data1,1)*(size(data1,1)*(size(data1,1)-1)));
        
        