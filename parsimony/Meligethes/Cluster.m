clc
clear all
x =xlsread('�˻�¶β����.xlsx');
%%���� X ���ݾ����ж���֮��ľ���----��hamming������������
Y = pdist(x,'hamming');
%%����ϵͳ����----��centroid���� ���ľ��뷨��
Z=linkage(Y,'average');
%%չʾ������--���Ը����޸�dendrogram(Z,n)����n��ʵ�֣�1 < n < ����������
%dendrogram(Z,0)���n=�����������������ʾ����Ҷ�ڵ㡣
dendrogram(Z,0);
%%��cophenet�������۾�����Ϣ----����pdist�������ɵ�Y��linkage�������ɵ�Z����ϵͳ��������cophenetic���ϵ��
c=cophenet(Z,Y);
%%���࣬���ؾ�����
T=cluster(Z,'cutoff',10,'depth',10);