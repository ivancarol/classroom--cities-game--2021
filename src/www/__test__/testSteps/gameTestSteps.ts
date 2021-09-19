import { PostLineStep, step } from "../testPost";
import { screen } from "@testing-library/dom";
import { testDispatch } from "../testStore";
import { gamePlayed } from "www/store/game/actions";
import { snapshotService } from "../testPost/SnapshotService";
import { playerReplaced } from "www/store/player/actions";

export const gameTestSteps: PostLineStep[] = [
  step(/You should be at the game screen/, () => {
    expect(screen.getByRole("heading", { name: "Game!" })).toBeInTheDocument();
  }),
  step(
    /Playing game should be "([^"]+)" created by "([^"]+)"/,
    (title, [, gameName, creatorName]) => {
      const header = screen.getByTestId("game-header");
      expect(header).toHaveTextContent(`${gameName} created by ${creatorName}`);
    }
  ),
  step(
    /"([^"]+)" is playing their game "([^"]+)"/,
    (title, [, creatorName, gameName]) => {
      const token = snapshotService.getToken()!;
      testDispatch(playerReplaced(creatorName, token));
      testDispatch(gamePlayed(gameName, creatorName));
    }
  ),
];