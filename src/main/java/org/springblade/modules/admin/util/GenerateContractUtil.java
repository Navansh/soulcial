package org.springblade.modules.admin.util;

import org.junit.jupiter.api.Test;
import org.web3j.codegen.SolidityFunctionWrapperGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class GenerateContractUtil {


	/**
	 * 利用abi信息 与 bin信息 生成对应的abi,bin文件
	 * @param abi 合约编译后的abi信息
	 * @param bin 合约编译后的bin信息
	 */
	public static void generateABIAndBIN(String abi,String bin,String abiFileName,String binFileName){

		File abiFile = new File("src/main/resources/"+abiFileName);
		File binFile = new File("src/main/resources/"+binFileName);
		BufferedOutputStream abiBos = null;
		BufferedOutputStream binBos = null;
		try{
			FileOutputStream abiFos = new FileOutputStream(abiFile);
			FileOutputStream binFos = new FileOutputStream(binFile);
			abiBos = new BufferedOutputStream(abiFos);
			binBos = new BufferedOutputStream(binFos);
			abiBos.write(abi.getBytes());
			abiBos.flush();
			binBos.write(bin.getBytes());
			binBos.flush();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(abiBos != null){
				try{
					abiBos.close();;
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			if(binBos != null){
				try {
					binBos.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	void genAbi(){
		String abi = "[\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"admin_\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"baseURI_\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"name_\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"symbol_\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"constructor\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"anonymous\": false,\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"owner\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"approved\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"Approval\",\n" +
			"\t\t\"type\": \"event\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"anonymous\": false,\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"owner\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"operator\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": false,\n" +
			"\t\t\t\t\"internalType\": \"bool\",\n" +
			"\t\t\t\t\"name\": \"approved\",\n" +
			"\t\t\t\t\"type\": \"bool\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"ApprovalForAll\",\n" +
			"\t\t\"type\": \"event\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"anonymous\": false,\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": false,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"account\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"Paused\",\n" +
			"\t\t\"type\": \"event\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"anonymous\": false,\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"from\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": true,\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"Transfer\",\n" +
			"\t\t\"type\": \"event\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"anonymous\": false,\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"indexed\": false,\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"account\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"Unpaused\",\n" +
			"\t\t\"type\": \"event\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"admin\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"approve\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"owner\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"balanceOf\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"newBaseURI\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"changeBaseURI\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"getApproved\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"owner\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"operator\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"isApprovedForAll\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bool\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"bool\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"name\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"ownerOf\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"paused\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bool\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"bool\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"safeMint\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"from\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"safeTransferFrom\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"from\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bytes\",\n" +
			"\t\t\t\t\"name\": \"_data\",\n" +
			"\t\t\t\t\"type\": \"bytes\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"safeTransferFrom\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"operator\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bool\",\n" +
			"\t\t\t\t\"name\": \"approved\",\n" +
			"\t\t\t\t\"type\": \"bool\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"setApprovalForAll\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"setPause\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bytes4\",\n" +
			"\t\t\t\t\"name\": \"interfaceId\",\n" +
			"\t\t\t\t\"type\": \"bytes4\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"supportsInterface\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"bool\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"bool\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"symbol\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"index\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"tokenByIndex\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"owner\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"index\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"tokenOfOwnerByIndex\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"tokenURI\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"string\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"string\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"totalSupply\",\n" +
			"\t\t\"outputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"stateMutability\": \"view\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"from\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"address\",\n" +
			"\t\t\t\t\"name\": \"to\",\n" +
			"\t\t\t\t\"type\": \"address\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"internalType\": \"uint256\",\n" +
			"\t\t\t\t\"name\": \"tokenId\",\n" +
			"\t\t\t\t\"type\": \"uint256\"\n" +
			"\t\t\t}\n" +
			"\t\t],\n" +
			"\t\t\"name\": \"transferFrom\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t},\n" +
			"\t{\n" +
			"\t\t\"inputs\": [],\n" +
			"\t\t\"name\": \"unsetPause\",\n" +
			"\t\t\"outputs\": [],\n" +
			"\t\t\"stateMutability\": \"nonpayable\",\n" +
			"\t\t\"type\": \"function\"\n" +
			"\t}\n" +
			"]";
		String bin = "60a06040523480156200001157600080fd5b5060405162003be438038062003be4833981810160405281019062000037919062000240565b8382828273ffffffffffffffffffffffffffffffffffffffff1660808173ffffffffffffffffffffffffffffffffffffffff1660601b8152505081600090805190602001906200008992919062000107565b508060019080519060200190620000a292919062000107565b505050506000600a60006101000a81548160ff0219169083151502179055508281604051602001620000d692919062000370565b604051602081830303815290604052600b9080519060200190620000fc92919062000107565b50505050506200053a565b82805462000115906200048c565b90600052602060002090601f01602090048101928262000139576000855562000185565b82601f106200015457805160ff191683800117855562000185565b8280016001018555821562000185579182015b828111156200018457825182559160200191906001019062000167565b5b50905062000194919062000198565b5090565b5b80821115620001b357600081600090555060010162000199565b5090565b6000620001ce620001c884620003d9565b620003a5565b905082815260208101848484011115620001e757600080fd5b620001f484828562000456565b509392505050565b6000815190506200020d8162000520565b92915050565b600082601f8301126200022557600080fd5b815162000237848260208601620001b7565b91505092915050565b600080600080608085870312156200025757600080fd5b60006200026787828801620001fc565b945050602085015167ffffffffffffffff8111156200028557600080fd5b620002938782880162000213565b935050604085015167ffffffffffffffff811115620002b157600080fd5b620002bf8782880162000213565b925050606085015167ffffffffffffffff811115620002dd57600080fd5b620002eb8782880162000213565b91505092959194509250565b600062000304826200040c565b62000310818562000417565b93506200032281856020860162000456565b80840191505092915050565b60006200033d60018362000417565b91507f2f000000000000000000000000000000000000000000000000000000000000006000830152600182019050919050565b60006200037e8285620002f7565b91506200038c8284620002f7565b915062000399826200032e565b91508190509392505050565b6000604051905081810181811067ffffffffffffffff82111715620003cf57620003ce620004f1565b5b8060405250919050565b600067ffffffffffffffff821115620003f757620003f6620004f1565b5b601f19601f8301169050602081019050919050565b600081519050919050565b600081905092915050565b60006200042f8262000436565b9050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60005b838110156200047657808201518184015260208101905062000459565b8381111562000486576000848401525b50505050565b60006002820490506001821680620004a557607f821691505b60208210811415620004bc57620004bb620004c2565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6200052b8162000422565b81146200053757600080fd5b50565b60805160601c61365a6200058a600039600081816107fb0152818161098801528181610aa501528181610c2201528181610eee0152818161101c0152818161125101526112b5015261365a6000f3fe608060405234801561001057600080fd5b50600436106101425760003560e01c80635c975abb116100b8578063a22cb4651161007c578063a22cb46514610375578063b88d4fde14610391578063c87b56dd146103ad578063d431b1ac146103dd578063e985e9c5146103e7578063f851a4401461041757610142565b80635c975abb146102bd5780636352211e146102db57806370a082311461030b57806395d89b411461033b578063a14481941461035957610142565b806323b872dd1161010a57806323b872dd146101ff5780632f745c591461021b57806339a0c6f91461024b57806342842e0e146102675780634f6ccce7146102835780634f842143146102b357610142565b806301ffc9a71461014757806306fdde0314610177578063081812fc14610195578063095ea7b3146101c557806318160ddd146101e1575b600080fd5b610161600480360381019061015c9190612610565b610435565b60405161016e9190612f5d565b60405180910390f35b61017f6104af565b60405161018c9190612f78565b60405180910390f35b6101af60048036038101906101aa91906126a3565b610541565b6040516101bc9190612ef6565b60405180910390f35b6101df60048036038101906101da91906125d4565b6105c6565b005b6101e96106de565b6040516101f691906131da565b60405180910390f35b610219600480360381019061021491906124ce565b6106eb565b005b610235600480360381019061023091906125d4565b610754565b60405161024291906131da565b60405180910390f35b61026560048036038101906102609190612662565b6107f9565b005b610281600480360381019061027c91906124ce565b6108cf565b005b61029d600480360381019061029891906126a3565b6108ef565b6040516102aa91906131da565b60405180910390f35b6102bb610986565b005b6102c5610a1e565b6040516102d29190612f5d565b60405180910390f35b6102f560048036038101906102f091906126a3565b610a35565b6040516103029190612ef6565b60405180910390f35b61032560048036038101906103209190612469565b610ad6565b60405161033291906131da565b60405180910390f35b610343610b8e565b6040516103509190612f78565b60405180910390f35b610373600480360381019061036e91906125d4565b610c20565b005b61038f600480360381019061038a9190612598565b610ccc565b005b6103ab60048036038101906103a6919061251d565b610e4d565b005b6103c760048036038101906103c291906126a3565b610eb8565b6040516103d49190612f78565b60405180910390f35b6103e5610eec565b005b61040160048036038101906103fc9190612492565b610f84565b60405161040e9190612f5d565b60405180910390f35b61041f611018565b60405161042c9190612ef6565b60405180910390f35b60007f780e9d63000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614806104a857506104a782611040565b5b9050919050565b6060600080546104be9061344f565b80601f01602080910402602001604051908101604052809291908181526020018280546104ea9061344f565b80156105375780601f1061050c57610100808354040283529160200191610537565b820191906000526020600020905b81548152906001019060200180831161051a57829003601f168201915b5050505050905090565b600061054c82611122565b61058b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105829061313a565b60405180910390fd5b6004600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60006105d182610a35565b90508073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415610642576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106399061317a565b60405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1661066161118e565b73ffffffffffffffffffffffffffffffffffffffff161480610690575061068f8161068a61118e565b610f84565b5b6106cf576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106c6906130da565b60405180910390fd5b6106d98383611196565b505050565b6000600880549050905090565b6106f48161124f565b6107056106ff61118e565b826112df565b610744576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161073b9061319a565b60405180910390fd5b61074f8383836113bd565b505050565b600061075f83610ad6565b82106107a0576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161079790612fba565b60405180910390fd5b600660008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600083815260200190815260200160002054905092915050565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610887576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161087e906130ba565b60405180910390fd5b6000610891610b8e565b905081816040516020016108a6929190612ea3565b604051602081830303815290604052600b90805190602001906108ca92919061228d565b505050565b6108ea83838360405180602001604052806000815250610e4d565b505050565b60006108f96106de565b821061093a576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610931906131ba565b60405180910390fd5b60088281548110610974577f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b90600052602060002001549050919050565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610a14576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a0b906130ba565b60405180910390fd5b610a1c611619565b565b6000600a60009054906101000a900460ff16905090565b6000806002600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610acc577f0000000000000000000000000000000000000000000000000000000000000000915050610ad1565b809150505b919050565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415610b47576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b3e906130fa565b60405180910390fd5b600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b606060018054610b9d9061344f565b80601f0160208091040260200160405190810160405280929190818152602001828054610bc99061344f565b8015610c165780601f10610beb57610100808354040283529160200191610c16565b820191906000526020600020905b815481529060010190602001808311610bf957829003601f168201915b5050505050905090565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610cae576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ca5906130ba565b60405180910390fd5b610cc88282604051806020016040528060008152506116bb565b5050565b610cd461118e565b73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415610d42576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610d399061305a565b60405180910390fd5b8060056000610d4f61118e565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff16610dfc61118e565b73ffffffffffffffffffffffffffffffffffffffff167f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3183604051610e419190612f5d565b60405180910390a35050565b610e568261124f565b610e67610e6161118e565b836112df565b610ea6576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e9d9061319a565b60405180910390fd5b610eb284848484611716565b50505050565b6060600b610ec583611772565b604051602001610ed6929190612ed2565b6040516020818303038152906040529050919050565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610f7a576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f71906130ba565b60405180910390fd5b610f8261191f565b565b6000600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b60007f0000000000000000000000000000000000000000000000000000000000000000905090565b60007f80ac58cd000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916148061110b57507f5b5e139f000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b8061111b575061111a826119c2565b5b9050919050565b60008073ffffffffffffffffffffffffffffffffffffffff166002600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614159050919050565b600033905090565b816004600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808273ffffffffffffffffffffffffffffffffffffffff1661120983610a35565b73ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b7f000000000000000000000000000000000000000000000000000000000000000073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156112dc576112ac81611122565b6112db576112da7f000000000000000000000000000000000000000000000000000000000000000082611a2c565b5b5b50565b60006112ea82611122565b611329576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016113209061307a565b60405180910390fd5b600061133483610a35565b90508073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614806113a357508373ffffffffffffffffffffffffffffffffffffffff1661138b84610541565b73ffffffffffffffffffffffffffffffffffffffff16145b806113b457506113b38185610f84565b5b91505092915050565b8273ffffffffffffffffffffffffffffffffffffffff166113dd82610a35565b73ffffffffffffffffffffffffffffffffffffffff1614611433576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161142a9061315a565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156114a3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161149a9061303a565b60405180910390fd5b6114ae838383611bfa565b6114b9600082611196565b6001600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546115099190613365565b925050819055506001600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825461156091906132de565b92505081905550816002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a4505050565b611621610a1e565b611660576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161165790612f9a565b60405180910390fd5b6000600a60006101000a81548160ff0219169083151502179055507f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa6116a461118e565b6040516116b19190612ef6565b60405180910390a1565b6116c58383611a2c565b6116d26000848484611c52565b611711576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161170890612fda565b60405180910390fd5b505050565b6117218484846113bd565b61172d84848484611c52565b61176c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161176390612fda565b60405180910390fd5b50505050565b606060008214156117ba576040518060400160405280600181526020017f3000000000000000000000000000000000000000000000000000000000000000815250905061191a565b600082905060005b600082146117ec5780806117d590613481565b915050600a826117e59190613334565b91506117c2565b60008167ffffffffffffffff81111561182e577f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6040519080825280601f01601f1916602001820160405280156118605781602001600182028036833780820191505090505b5090505b60008514611913576001826118799190613365565b9150600a8561188891906134ca565b603061189491906132de565b60f81b8183815181106118d0577f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600a8561190c9190613334565b9450611864565b8093505050505b919050565b611927610a1e565b15611967576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161195e9061309a565b60405180910390fd5b6001600a60006101000a81548160ff0219169083151502179055507f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a2586119ab61118e565b6040516119b89190612ef6565b60405180910390a1565b60007f01ffc9a7000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916149050919050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611a9c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401611a939061311a565b60405180910390fd5b611aa581611122565b15611ae5576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401611adc90612ffa565b60405180910390fd5b611af160008383611bfa565b6001600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254611b4191906132de565b92505081905550816002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808273ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a45050565b611c05838383611de9565b611c0d610a1e565b15611c4d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401611c449061301a565b60405180910390fd5b505050565b6000611c738473ffffffffffffffffffffffffffffffffffffffff16611efd565b15611ddc578373ffffffffffffffffffffffffffffffffffffffff1663150b7a02611c9c61118e565b8786866040518563ffffffff1660e01b8152600401611cbe9493929190612f11565b602060405180830381600087803b158015611cd857600080fd5b505af1925050508015611d0957506040513d601f19601f82011682018060405250810190611d069190612639565b60015b611d8c573d8060008114611d39576040519150601f19603f3d011682016040523d82523d6000602084013e611d3e565b606091505b50600081511415611d84576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401611d7b90612fda565b60405180910390fd5b805181602001fd5b63150b7a0260e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916817bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614915050611de1565b600190505b949350505050565b611df4838383611f10565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415611e3757611e3281611f15565b611e76565b8173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614611e7557611e748382611f5e565b5b5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611eb957611eb4816120cb565b611ef8565b8273ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614611ef757611ef6828261220e565b5b5b505050565b600080823b905060008111915050919050565b505050565b6008805490506009600083815260200190815260200160002081905550600881908060018154018082558091505060019003906000526020600020016000909190919091505550565b60006001611f6b84610ad6565b611f759190613365565b905060006007600084815260200190815260200160002054905081811461205a576000600660008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084815260200190815260200160002054905080600660008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084815260200190815260200160002081905550816007600083815260200190815260200160002081905550505b6007600084815260200190815260200160002060009055600660008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008381526020019081526020016000206000905550505050565b600060016008805490506120df9190613365565b9050600060096000848152602001908152602001600020549050600060088381548110612135577f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b90600052602060002001549050806008838154811061217d577f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b9060005260206000200181905550816009600083815260200190815260200160002081905550600960008581526020019081526020016000206000905560088054806121f2577f4e487b7100000000000000000000000000000000000000000000000000000000600052603160045260246000fd5b6001900381819060005260206000200160009055905550505050565b600061221983610ad6565b905081600660008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600083815260200190815260200160002081905550806007600084815260200190815260200160002081905550505050565b8280546122999061344f565b90600052602060002090601f0160209004810192826122bb5760008555612302565b82601f106122d457805160ff1916838001178555612302565b82800160010185558215612302579182015b828111156123015782518255916020019190600101906122e6565b5b50905061230f9190612313565b5090565b5b8082111561232c576000816000905550600101612314565b5090565b600061234361233e84613226565b6131f5565b90508281526020810184848401111561235b57600080fd5b61236684828561340d565b509392505050565b600061238161237c84613256565b6131f5565b90508281526020810184848401111561239957600080fd5b6123a484828561340d565b509392505050565b6000813590506123bb816135c8565b92915050565b6000813590506123d0816135df565b92915050565b6000813590506123e5816135f6565b92915050565b6000815190506123fa816135f6565b92915050565b600082601f83011261241157600080fd5b8135612421848260208601612330565b91505092915050565b600082601f83011261243b57600080fd5b813561244b84826020860161236e565b91505092915050565b6000813590506124638161360d565b92915050565b60006020828403121561247b57600080fd5b6000612489848285016123ac565b91505092915050565b600080604083850312156124a557600080fd5b60006124b3858286016123ac565b92505060206124c4858286016123ac565b9150509250929050565b6000806000606084860312156124e357600080fd5b60006124f1868287016123ac565b9350506020612502868287016123ac565b925050604061251386828701612454565b9150509250925092565b6000806000806080858703121561253357600080fd5b6000612541878288016123ac565b9450506020612552878288016123ac565b935050604061256387828801612454565b925050606085013567ffffffffffffffff81111561258057600080fd5b61258c87828801612400565b91505092959194509250565b600080604083850312156125ab57600080fd5b60006125b9858286016123ac565b92505060206125ca858286016123c1565b9150509250929050565b600080604083850312156125e757600080fd5b60006125f5858286016123ac565b925050602061260685828601612454565b9150509250929050565b60006020828403121561262257600080fd5b6000612630848285016123d6565b91505092915050565b60006020828403121561264b57600080fd5b6000612659848285016123eb565b91505092915050565b60006020828403121561267457600080fd5b600082013567ffffffffffffffff81111561268e57600080fd5b61269a8482850161242a565b91505092915050565b6000602082840312156126b557600080fd5b60006126c384828501612454565b91505092915050565b6126d581613399565b82525050565b6126e4816133ab565b82525050565b60006126f58261329b565b6126ff81856132b1565b935061270f81856020860161341c565b612718816135b7565b840191505092915050565b600061272e826132a6565b61273881856132c2565b935061274881856020860161341c565b612751816135b7565b840191505092915050565b6000612767826132a6565b61277181856132d3565b935061278181856020860161341c565b80840191505092915050565b6000815461279a8161344f565b6127a481866132d3565b945060018216600081146127bf57600181146127d057612803565b60ff19831686528186019350612803565b6127d985613286565b60005b838110156127fb578154818901526001820191506020810190506127dc565b838801955050505b50505092915050565b60006128196014836132c2565b91507f5061757361626c653a206e6f74207061757365640000000000000000000000006000830152602082019050919050565b6000612859602b836132c2565b91507f455243373231456e756d657261626c653a206f776e657220696e646578206f7560008301527f74206f6620626f756e64730000000000000000000000000000000000000000006020830152604082019050919050565b60006128bf6032836132c2565b91507f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560008301527f63656976657220696d706c656d656e74657200000000000000000000000000006020830152604082019050919050565b6000612925601c836132c2565b91507f4552433732313a20746f6b656e20616c7265616479206d696e746564000000006000830152602082019050919050565b6000612965602b836132c2565b91507f4252433732315061757361626c653a20746f6b656e207472616e73666572207760008301527f68696c65207061757365640000000000000000000000000000000000000000006020830152604082019050919050565b60006129cb6024836132c2565b91507f4552433732313a207472616e7366657220746f20746865207a65726f2061646460008301527f72657373000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000612a316019836132c2565b91507f4552433732313a20617070726f766520746f2063616c6c6572000000000000006000830152602082019050919050565b6000612a71602c836132c2565b91507f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860008301527f697374656e7420746f6b656e00000000000000000000000000000000000000006020830152604082019050919050565b6000612ad76010836132c2565b91507f5061757361626c653a20706175736564000000000000000000000000000000006000830152602082019050919050565b6000612b176011836132c2565b91507f726573747269637420746f2061646d696e0000000000000000000000000000006000830152602082019050919050565b6000612b576038836132c2565b91507f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f7760008301527f6e6572206e6f7220617070726f76656420666f7220616c6c00000000000000006020830152604082019050919050565b6000612bbd602a836132c2565b91507f4552433732313a2062616c616e636520717565727920666f7220746865207a6560008301527f726f2061646472657373000000000000000000000000000000000000000000006020830152604082019050919050565b6000612c236020836132c2565b91507f4552433732313a206d696e7420746f20746865207a65726f20616464726573736000830152602082019050919050565b6000612c63602c836132c2565b91507f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860008301527f697374656e7420746f6b656e00000000000000000000000000000000000000006020830152604082019050919050565b6000612cc96029836132c2565b91507f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960008301527f73206e6f74206f776e00000000000000000000000000000000000000000000006020830152604082019050919050565b6000612d2f6021836132c2565b91507f4552433732313a20617070726f76616c20746f2063757272656e74206f776e6560008301527f72000000000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000612d956031836132c2565b91507f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f60008301527f776e6572206e6f7220617070726f7665640000000000000000000000000000006020830152604082019050919050565b6000612dfb602c836132c2565b91507f455243373231456e756d657261626c653a20676c6f62616c20696e646578206f60008301527f7574206f6620626f756e647300000000000000000000000000000000000000006020830152604082019050919050565b6000612e616001836132d3565b91507f2f000000000000000000000000000000000000000000000000000000000000006000830152600182019050919050565b612e9d81613403565b82525050565b6000612eaf828561275c565b9150612ebb828461275c565b9150612ec682612e54565b91508190509392505050565b6000612ede828561278d565b9150612eea828461275c565b91508190509392505050565b6000602082019050612f0b60008301846126cc565b92915050565b6000608082019050612f2660008301876126cc565b612f3360208301866126cc565b612f406040830185612e94565b8181036060830152612f5281846126ea565b905095945050505050565b6000602082019050612f7260008301846126db565b92915050565b60006020820190508181036000830152612f928184612723565b905092915050565b60006020820190508181036000830152612fb38161280c565b9050919050565b60006020820190508181036000830152612fd38161284c565b9050919050565b60006020820190508181036000830152612ff3816128b2565b9050919050565b6000602082019050818103600083015261301381612918565b9050919050565b6000602082019050818103600083015261303381612958565b9050919050565b60006020820190508181036000830152613053816129be565b9050919050565b6000602082019050818103600083015261307381612a24565b9050919050565b6000602082019050818103600083015261309381612a64565b9050919050565b600060208201905081810360008301526130b381612aca565b9050919050565b600060208201905081810360008301526130d381612b0a565b9050919050565b600060208201905081810360008301526130f381612b4a565b9050919050565b6000602082019050818103600083015261311381612bb0565b9050919050565b6000602082019050818103600083015261313381612c16565b9050919050565b6000602082019050818103600083015261315381612c56565b9050919050565b6000602082019050818103600083015261317381612cbc565b9050919050565b6000602082019050818103600083015261319381612d22565b9050919050565b600060208201905081810360008301526131b381612d88565b9050919050565b600060208201905081810360008301526131d381612dee565b9050919050565b60006020820190506131ef6000830184612e94565b92915050565b6000604051905081810181811067ffffffffffffffff8211171561321c5761321b613588565b5b8060405250919050565b600067ffffffffffffffff82111561324157613240613588565b5b601f19601f8301169050602081019050919050565b600067ffffffffffffffff82111561327157613270613588565b5b601f19601f8301169050602081019050919050565b60008190508160005260206000209050919050565b600081519050919050565b600081519050919050565b600082825260208201905092915050565b600082825260208201905092915050565b600081905092915050565b60006132e982613403565b91506132f483613403565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115613329576133286134fb565b5b828201905092915050565b600061333f82613403565b915061334a83613403565b92508261335a5761335961352a565b5b828204905092915050565b600061337082613403565b915061337b83613403565b92508282101561338e5761338d6134fb565b5b828203905092915050565b60006133a4826133e3565b9050919050565b60008115159050919050565b60007fffffffff0000000000000000000000000000000000000000000000000000000082169050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b82818337600083830152505050565b60005b8381101561343a57808201518184015260208101905061341f565b83811115613449576000848401525b50505050565b6000600282049050600182168061346757607f821691505b6020821081141561347b5761347a613559565b5b50919050565b600061348c82613403565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156134bf576134be6134fb565b5b600182019050919050565b60006134d582613403565b91506134e083613403565b9250826134f0576134ef61352a565b5b828206905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6000601f19601f8301169050919050565b6135d181613399565b81146135dc57600080fd5b50565b6135e8816133ab565b81146135f357600080fd5b50565b6135ff816133b7565b811461360a57600080fd5b50565b61361681613403565b811461362157600080fd5b5056fea2646970667358221220468150c2b3d54198a23490dface0ad63b61d49113458fff6ede3c1cf89a3677664736f6c63430008000033";

		String abiFileName = "leaveMsg.abi";
		String binFileName = "leaveMsg.bin";

		generateABIAndBIN(abi,bin,abiFileName,binFileName);
	}


	@Test
	void generateJavaFile(){
		String abiFile = "src/main/resources/leaveMsg.abi";
		String binFile = "src/main/resources/leaveMsg.bin";
		String generateFile = "src/main/java/org/springblade/modules/admin/util/";
		generateClass(abiFile,binFile,generateFile);
	}

	/**
	 *
	 * 生成合约的java代码
	 * 其中 -p 为生成java代码的包路径此参数和 -o 参数配合使用，以便将java文件放入正确的路径当中
	 * @param abiFile abi的文件路径
	 * @param binFile bin的文件路径
	 * @param generateFile 生成的java文件路径
	 */
	public static void generateClass(String abiFile,String binFile,String generateFile){
		String[] args = Arrays.asList(
			"-a",abiFile,
			"-b",binFile,
			"-p","",
			"-o",generateFile
		).toArray(new String[0]);
		Stream.of(args).forEach(System.out::println);
		SolidityFunctionWrapperGenerator.main(args);
	}

}
