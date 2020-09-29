package testProject;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {

	static Scanner scanner = new Scanner(System.in);

	public static void menu() {
		while (true) {
			System.out.println("### 물품 비교 프로그램 ###");
			System.out.println("######## 메뉴 ########");
			System.out.println("[1] 물품 비교하기");
			System.out.println("[2] 물품 수정하기");
			System.out.println("[3] 물품 입력하기");
			System.out.println("[4] 물품 삭제하기");
			System.out.println("[5] 프로그램 종료");
			System.out.print("Input number : ");
			String select = scanner.nextLine();

			if (select.equals("1")) {
				compare();
				break;
			} else if (select.equals("2")) {
				update();
				break;
			} else if (select.equals("3")) {
				insert();
				break;
			} else if (select.equals("4")) {
				delete();
				break;
			} else if (select.equals("5")) {
				break;
			} else {
				System.out.println("번호를 다시 입력하세요");
			}
		}
	}

	public static void compare() {
		while (true) {
			try {
				List<Integer> itemList1;
				List<Integer> itemList2;

				select();
				System.out.println("[-1] 상위 메뉴 이동");
				System.out.println("비교할 첫 번째 컴퓨터의 번호를 선택하세요");
				System.out.print("Input number : ");
				int select1 = scanner.nextInt();
//				Item item = new Item(select1);
				itemList1 = ItemDAO.getSelectNo(select1);
				System.out.println("비교할 두 번째 컴퓨터의 번호를 선택하세요");
				System.out.print("Input number : ");
				int select2 = scanner.nextInt();
				scanner.nextLine();
				itemList2 = ItemDAO.getSelectNo(select2);
				if (itemList1.contains(select1) && itemList2.contains(select2)) {
					System.out.println("#### 물품 비교 결과 ####");
					select(select1, select2);
					int weight1 = ItemDAO.getSelectWeight(select1);
					int weight2 = ItemDAO.getSelectWeight(select2);
					if (weight1 > weight2) {
						System.out.println("무게 :" + weight1 + " > " + weight2);
					} else if (weight1 < weight2) {
						System.out.println("무게 :" + weight1 + " < " + weight2);
					} else {
						System.out.println("무게 :" + weight1 + " = " + weight2);
					}

					int screen1 = ItemDAO.getSelectScreen(select1);
					int screen2 = ItemDAO.getSelectScreen(select2);
					if (screen1 > screen2) {
						System.out.println("화면 :" + screen1 + " > " + screen2);
					} else if (screen1 < screen2) {
						System.out.println("화면 :" + screen1 + " < " + screen2);
					} else {
						System.out.println("화면 :" + screen1 + " = " + screen2);
					}

					int capacity1 = ItemDAO.getSelectCapacity(select1);
					int capacity2 = ItemDAO.getSelectCapacity(select2);
					if (capacity1 > capacity2) {
						System.out.println("디스크용량 :" + capacity1 + " > " + capacity2);
					} else if (capacity1 < capacity2) {
						System.out.println("디스크용량 :" + capacity1 + " < " + capacity2);
					} else {
						System.out.println("디스크용량 :" + capacity1 + " = " + capacity2);
					}

					int price1 = ItemDAO.getSelectPrice(select1);
					int price2 = ItemDAO.getSelectPrice(select2);
					if (price1 > price2) {
						System.out.println("가격 :" + price1 + " > " + price2);
					} else if (price1 < price2) {
						System.out.println("가격 :" + price1 + " < " + price2);
					} else {
						System.out.println("가격 :" + price1 + " = " + price2);
					}

					System.out.println("추천 : 무게(20점), 화면(20점), 용량(20점), 가격(40점)");
					String name1 = ItemDAO.getSelectName(select1);
					String name2 = ItemDAO.getSelectName(select2);

					String result1 = "";
					String result2 = "";
					int count1 = 0;
					int count2 = 0;

					if (weight1 > weight2) {
						result1 = name1 + " : ";
						result2 = name2 + " : 무게(20점) ";
						count2 += 20;
					} else if (weight2 > weight1) {
						result1 = name1 + " : 무게(20점) ";
						result2 = name2 + " : ";
						count1 += 20;
					} else {
						result1 = name1 + " : ";
						result2 = name2 + " : ";
					}
					if (result1.contains("무게") && screen1 > screen2) {
						result1 = result1 + "+ 화면(20점) ";
						count1 += 20;
					} else if (!result1.contains("무게") && screen1 > screen2) {
						result1 = result1 + "화면(20점) ";
						count1 += 20;
					}
					if (result2.contains("무게") && screen2 > screen1) {
						result2 = result2 + "+ 화면(20점) ";
						count2 += 20;
					} else if (!result2.contains("무게") && screen2 > screen1) {
						result2 = result2 + "화면(20점) ";
						count2 += 20;
					}

					if ((result1.contains("무게") || result1.contains("화면")) && capacity1 > capacity2) {
						result1 = result1 + "+ 용량(20점) ";
						count1 += 20;
					} else if (!(result1.contains("무게") || result1.contains("화면")) && capacity1 > capacity2) {
						result1 = result1 + "용량(20점) ";
						count1 += 20;
					}
					if ((result2.contains("무게") || result2.contains("화면")) && capacity2 > capacity1) {
						result2 = result2 + "+ 용량(20점) ";
						count2 += 20;
					} else if (!(result1.contains("무게") || result1.contains("화면")) && capacity2 > capacity1) {
						result2 = result2 + "용량(20점) ";
						count2 += 20;
					}

					if ((result1.contains("무게") || result1.contains("화면") || result1.contains("용량") && price1 > price2)
							&& price1 < price2) {
						result1 = result1 + "+ 가격(40점) ";
						count1 += 40;
						result1 = result1 + "= " + count1 + "점";
						result2 = result2 + "= " + count2 + "점";
					} else if (!(result1.contains("무게") || result1.contains("화면") || result1.contains("용량"))
							&& price1 < price2) {
						result1 = result1 + "가격(40점) ";
						count1 += 40;
						result1 = result1 + "= " + count1 + "점";
						result2 = result2 + "= " + count2 + "점";
					}
					if ((result2.contains("무게") || result2.contains("화면") || result2.contains("용량"))
							&& price2 < price1) {
						result2 = result2 + "+ 가격(40점) ";
						count2 += 40;
						result1 = result1 + "= " + count1 + "점";
						result2 = result2 + "= " + count2 + "점";
					} else if (!(result2.contains("무게") || result2.contains("화면") || result2.contains("용량"))
							&& price2 < price1) {
						result2 = result2 + "가격(40점) ";
						count2 += 40;
						result1 = result1 + "= " + count1 + "점";
						result2 = result2 + "= " + count2 + "점";
					}

					System.out.println(result1);
					System.out.println(result2);
					System.out.print("최종 추천 : ");
					if (count1 > count2) {
						System.out.println(name1);
					} else if (count2 > count1) {
						System.out.println(name2);
					} else {
						System.out.println("동일한 점수입니다.");
					}
					System.out.println("더 비교하시겠습니까?");
					System.out.println("[1] 예");
					System.out.println("[2] 아니요(상위 메뉴로 이동)");
					String more = scanner.nextLine();

					if (more.equals("1")) {
						compare();
						break;
					} else if (more.equals("2")) {
						menu();
						break;
					} else {
						System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
					}

				} else if (select1 == -1) {
					scanner.nextLine();
					menu();
					break;
				} else {
					System.out.println("입력 오류 입니다. 다시 입력하세요");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}
	}

	public static void select() {
		System.out.println("### 물품 리스트 ###");
		System.out.println("No  이름            무게(g)   화면(인치)    디스크용량(기가바이트)    비고      가격(만원)");
		List<Item> itemList;
		try {
			itemList = ItemDAO.getSelect();
			for (Item item : itemList) {
				System.out.println(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void select(int num, int num2) {
		System.out.println("### 물품 리스트 ###");
		System.out.println("No  이름            무게(g)   화면(인치)    디스크용량(기가바이트)    비고      가격(만원)");
		List<Item> itemList;
		try {
			itemList = ItemDAO.getSelect(num, num2);
			for (Item item : itemList) {
				System.out.println(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update() {
		List<Item> itemList;
		List<Integer> itemList2;
		String update;
		String updateName;
		String updateEtc;
		int updateWeight;
		int updateScreen;
		int updateCapacity;
		int updatePrice;
		String query;

		select();
		while (true) {
			try {
				System.out.println("[-1] 상위 메뉴 이동");
				System.out.println("몇 번을 수정하시겠습니까?");
				int no = scanner.nextInt();
				Item item = new Item(no);
				itemList2 = ItemDAO.getSelectNo(no);
				if (itemList2.contains(no)) {
					while (true) {
						try {
							System.out.println("무엇을 수정하시겠습니까?");
							System.out.println("[1] 이름");
							System.out.println("[2] 무게(그램)");
							System.out.println("[3] 화면(인치)");
							System.out.println("[4] 디스크용량(기가바이트)");
							System.out.println("[5] 비고");
							System.out.println("[6] 가격(만원)");
							System.out.print("Input number : ");
							int select = scanner.nextInt();
							if (select == 1) {
								update = ItemDAO.ITEM_COLUMN_NAME;
								System.out.println("수정할 이름을 입력하세요");
								updateName = scanner.next();
								query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET " + update + " = '" + updateName
										+ "' WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
								ItemDAO.update(query);
								System.out.println("수정 완료!");
								System.out.println("더 수정 하시겠습니까?");
								System.out.println("[1] 수정");
								System.out.println("나가시려면 아무 버튼이나 누르세요");
								System.out.print("Input number : ");
								String more = scanner.nextLine();
								if (more.equals("1")) {
									update();
									break;
								} else {
									menu();
									break;
								}

							} else if (select == 2) {
								update = ItemDAO.ITEM_COLUMN_WEIGHT;
								System.out.println("수정할 무게를 입력하세요");
								updateWeight = scanner.nextInt();
								if (updateWeight > 0) {
									query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET `" + update + "` = "
											+ updateWeight + " WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
									ItemDAO.update(query);
									scanner.nextLine();
									System.out.println("수정 완료!");
									System.out.println("더 수정 하시겠습니까?");
									System.out.println("[1] 수정");
									System.out.println("나가시려면 아무 버튼이나 누르세요");
									System.out.print("Input number : ");
									String more = scanner.nextLine();
									if (more.equals("1")) {
										update();
										break;
									} else {
										menu();
										break;
									}
								} else {
									System.out.println("다시 입력하세요!");
								}
							} else if (select == 3) {
								update = ItemDAO.ITEM_COLUMN_SCREEN;
								System.out.println("수정할 화면 크기를 입력하세요");
								updateScreen = scanner.nextInt();
								if (updateScreen > 0) {
									query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET `" + update + "` = "
											+ updateScreen + " WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
									ItemDAO.update(query);
									scanner.nextLine();
									System.out.println("수정 완료!");
									System.out.println("더 수정 하시겠습니까?");
									System.out.println("[1] 수정");
									System.out.println("나가시려면 아무 버튼이나 누르세요");
									System.out.print("Input number : ");
									String more = scanner.nextLine();
									if (more.equals("1")) {
										update();
										break;
									} else {
										menu();
										break;
									}
								} else {
									System.out.println("다시 입력하세요!");
								}
							} else if (select == 4) {
								update = ItemDAO.ITEM_COLUMN_CAPACITY;
								System.out.println("수정할 컴퓨터 용량을 입력하세요");
								updateCapacity = scanner.nextInt();
								if (updateCapacity > 0) {
									query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET `" + update + "` = "
											+ updateCapacity + " WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
									ItemDAO.update(query);
									scanner.nextLine();
									System.out.println("수정 완료!");
									System.out.println("더 수정 하시겠습니까?");
									System.out.println("[1] 수정");
									System.out.println("나가시려면 아무 버튼이나 누르세요");
									System.out.print("Input number : ");
									String more = scanner.nextLine();
									if (more.equals("1")) {
										update();
										break;
									} else {
										menu();
										break;
									}
								} else {
									System.out.println("다시 입력하세요!");
								}
							} else if (select == 5) {
								update = ItemDAO.ITEM_COLUMN_ETC;
								System.out.println("수정할 비고를 입력하세요");
								updateEtc = scanner.next();
								query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET " + update + " = '" + updateEtc
										+ "' WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
								ItemDAO.update(query);
								scanner.nextLine();
								System.out.println("수정 완료!");
								System.out.println("더 수정 하시겠습니까?");
								System.out.println("[1] 수정");
								System.out.println("나가시려면 아무 버튼이나 누르세요");
								System.out.print("Input number : ");
								String more = scanner.nextLine();
								if (more.equals("1")) {
									update();
									break;
								} else {
									menu();
									break;
								}
							} else if (select == 6) {
								update = ItemDAO.ITEM_COLUMN_PRICE;
								System.out.println("수정할 컴퓨터 가격을 입력하세요");
								updatePrice = scanner.nextInt();
								if (updatePrice > 0) {
									query = "UPDATE " + ItemDAO.ITEM_TABLE_NAME + " SET `" + update + "` = "
											+ updatePrice + " WHERE " + ItemDAO.ITEM_COLUMN_NO + " = " + no;
									ItemDAO.update(query);
									scanner.nextLine();
									System.out.println("수정 완료!");
									System.out.println("더 수정 하시겠습니까?");
									System.out.println("[1] 수정");
									System.out.println("나가시려면 아무 버튼이나 누르세요");
									System.out.print("Input number : ");
									String more = scanner.nextLine();
									if (more.equals("1")) {
										update();
										break;
									} else {
										menu();
										break;
									}
								} else {
									System.out.println("다시 입력하세요!");
								}
							} else {
								System.out.println("다시 입력하세요");
							}

						} catch (InputMismatchException e) {
							scanner = new Scanner(System.in);
							System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
						}
					}
				} else if (no == -1) {
					scanner.nextLine();
					menu();
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}

	}

	public static void insert() {
		String insertName;
		int insertWeight;
		int insertScreen;
		int insertCapacity;
		String insertEtc;
		int insertPrice;

		System.out.println("[-1] 상위 메뉴 이동");
		System.out.println("컴퓨터의 이름이 무엇입니까?");
		insertName = scanner.nextLine();
		if (insertName.equals("-1")) {
			menu();
		}
		System.out.println("컴퓨터의 무게는 무엇입니까? (그램 단위, 숫자 입력) ex) 1200");
		while (true) {
			try {
				insertWeight = scanner.nextInt();
				if (insertWeight < 0) {
					System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				}
				break;
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}
		System.out.println("컴퓨터 화면의 크기는 몇 인치 입니까? (인치 단위, 숫자 입력) ex) 17");
		while (true) {
			try {
				insertScreen = scanner.nextInt();
				if (insertScreen < 0) {
					System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				}
				break;
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}
		System.out.println("컴퓨터 용량은 몇 기가바이트 입니까? (기가바이트 단위, 숫자 입력) ex) 320");
		while (true) {
			try {
				insertCapacity = scanner.nextInt();
				scanner.nextLine();
				if (insertCapacity < 0) {
					System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				}
				break;
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}
		System.out.println("비고를 입력하세요 ex) NA");
		insertEtc = scanner.nextLine();
		System.out.println("컴퓨터 가격은 얼마 입니까? (만원 단위, 숫자 입력) ex) 80");
		while (true) {
			try {
				insertPrice = scanner.nextInt();
				scanner.nextLine();
				if (insertPrice < 0) {
					System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
				}
				break;
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			}
		}
		Item item = new Item(insertName, insertWeight, insertScreen, insertCapacity, insertEtc, insertPrice);
		try {
			ItemDAO.getInsert(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("입력이 완료되었습니다.");
		System.out.println("더 입력 하시겠습니까?");
		System.out.println("[1] 입력");
		System.out.println("나가시려면 아무 버튼이나 누르세요");
		System.out.print("Input number : ");
		String more = scanner.nextLine();
		if (more.equals("1")) {
			insert();
		} else {
			menu();
		}
	}

	public static void delete() {
		List<Item> itemList;
		List<Integer> itemList2;

		select();
		System.out.println("[-1] 상위 메뉴 이동");
		System.out.println("삭제하실 컴퓨터의 번호를 입력하세요.");
		System.out.print("Input number : ");

		while (true) {
			try {
				int num = scanner.nextInt();
				Item item = new Item(num);
				itemList2 = ItemDAO.getSelectNo(num);
				if (itemList2.contains(num)) {
					ItemDAO.delete(item);
					scanner.nextLine();
					System.out.println("삭제 완료.");
					System.out.println("더 삭제 하시겠습니까?");
					System.out.println("[1] 삭제");
					System.out.println("나가시려면 아무 버튼이나 누르세요");
					System.out.print("Input number : ");
					String more = scanner.nextLine();
					if (more.equals("1")) {
						update();
						break;
					} else {
						menu();
						break;
					}

				} else if (num == -1) {
					scanner.nextLine();
					menu();
					break;
				} else {
					System.out.println("다시 입력하세요");
				}
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
