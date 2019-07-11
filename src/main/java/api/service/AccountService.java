package api.service;

import api.dao.AccountDao;
import api.domain.Account;
import api.domain.Transaction;
import api.request.AccountRequest;
import api.request.TransferRequest;
import api.response.ApiConstants;
import api.response.ApiResponse;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;
import server.undertow.exchange.Exchange;
import server.undertow.handlers.ApiHandlers;

/**
 * Created by intel on 7/8/2019.
 */
public class AccountService {
   public static  AccountDao accountDao = new AccountDao();



    public static void createAccount(HttpServerExchange exchange) {
        Account accountInput = AccountRequest.getAccount(exchange);
        Account account = accountDao.createAccount(accountInput);
        if (null == account) {
            ApiHandlers.badRequest(exchange, String.format("Account %s already exists.", accountInput.getAccountId()),
                    ApiConstants.ACCOUNT_ID_REQUIRED);
            return;
        }
        ApiResponse response = new ApiResponse(ApiConstants.ACCOUNT_CREATED, "Account Created Successfully");
        exchange.setStatusCode(StatusCodes.CREATED);
        Exchange.body().sendJson(exchange, response);
    }

    public static void getAccount(HttpServerExchange exchange) {
        String accountId = AccountRequest.accountid(exchange);
        System.out.println("Account id is ---> "+ accountId);
        Account account = accountDao.getAccount(accountId);

        System.out.println("Account from repo is --> "+ account);
        if(null == accountId){
            ApiHandlers.badRequest(exchange, String.format("Account Id %s does not exist .",accountId),
                    ApiConstants.ACCOUNT_ID_REQUIRED);
            return;
        }
        if(null == account){
            ApiHandlers.badRequest(exchange, String.format("Account with accountId  %s does not exist .",accountId), ApiConstants.NO_ACCOUNT_EXIST);
            return;
        }
        exchange.setStatusCode(StatusCodes.OK);
        Exchange.body().sendJson(exchange, account);
    }

    public static void transfer(HttpServerExchange exchange) {
        Transaction transaction = TransferRequest.getTransaction(exchange);
        ApiResponse response = transfer(transaction);
        exchange.setStatusCode(StatusCodes.OK);
        Exchange.body().sendJson(exchange, response);
    }

    private static synchronized ApiResponse transfer(Transaction transaction) {
            Account fromAccount = accountDao.getAccount(transaction.getFromAccountId());
            Account toAccount = accountDao.getAccount(transaction.getToAccountId());
            if(fromAccount == null) {
                ApiResponse response = new ApiResponse(ApiConstants.NO_ACCOUNT_EXIST,
                        String.format("Account with 5s account Id does not exist", transaction.getFromAccountId()));
                return response;
            }
            if(toAccount == null) {
                ApiResponse response = new ApiResponse(ApiConstants.NO_ACCOUNT_EXIST,
                        String.format("Account with 5s account Id does not exist", transaction.getToAccountId()));
                return response;
            }
            if(fromAccount.getAccountBalance() < transaction.getAmount()) {
                ApiResponse response = new ApiResponse(ApiConstants.INSUFFICIENT_ACCOUNT_BALANCE,
                        String.format("Account with 5s account Id has insufficient balance for transfer",
                        transaction.getFromAccountId()));
                return response;
            }

            fromAccount.setAccountBalance(fromAccount.getAccountBalance() - transaction.getAmount());
            toAccount.setAccountBalance(toAccount.getAccountBalance() + transaction.getAmount());
        ApiResponse response = new ApiResponse(ApiConstants.AMOUNT_SUCCESSFULLY_TRANSFERRED, "Transaction successfull");
        return response;

    }
}
