package com.dp;

public class FindIsInterleavingStrings {

}
// Day 16
//bool isInterleaving(char*s1, char*s2, char*s3)
//{
//	if(*s1=='\0' && *s2=='\0' && *s3=='\0'){ return true; }
//	
//	if(*s1=='\0'){ return (strcmp(s2, s3)==0); }
//	if(*s2=='\0'){ return (strcmp(s1, s3)==0); }
//
//	if(*s3 == *s2 && *s3 == *s1)
//	{
//		return (isInterleaving(s1+1, s2, s3+1) || isInterleaving(s1, s2+1, s3+1));
//	}
//	else if(*s3 == *s2)
//		return isInterleaving(s1, s2+1, s3+1);
//	else if(*s3 == *s1)
//		return (isInterleaving(s1+1, s2, s3+1);
//	else
//		return false;
//}
