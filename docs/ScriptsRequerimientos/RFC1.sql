
    
--SELECT * FROM CLIENTE;
SELECT sucursal, sum(total) FROM venta WHERE fechaventa BETWEEN TO_DATE('2018/9/12','yyyy/mm/dd') AND TO_DATE('2018/12/12','yyyy/mm/dd') GROUP BY sucursal;
commit;
rollback;