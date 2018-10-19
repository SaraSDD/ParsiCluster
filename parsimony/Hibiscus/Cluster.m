clc
clear all
x =xlsread('菜花露尾甲属.xlsx');
%%计算 X 数据矩阵中对象之间的距离----‘hamming’：汉明距离
Y = pdist(x,'hamming');
%%计算系统聚类----‘centroid’： 质心距离法；
Z=linkage(Y,'average');
%%展示聚类结果--可以根据修改dendrogram(Z,n)参数n来实现，1 < n < 样本个数。
%dendrogram(Z,0)则表n=样本个数的情况，显示所有叶节点。
dendrogram(Z,0);
%%用cophenet函数评价聚类信息----利用pdist函数生成的Y和linkage函数生成的Z计算系统聚类树的cophenetic相关系数
c=cophenet(Z,Y);
%%聚类，返回聚类列
T=cluster(Z,'cutoff',10,'depth',10);